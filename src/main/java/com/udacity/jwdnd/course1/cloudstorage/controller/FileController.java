package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;

import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.time.LocalDate;


@Controller
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("fileUpload")MultipartFile fileUpload, Authentication authentication, Model model) throws IOException {
//        InputStream fis = fileUpload.getInputStream();

        int userId = userService.getUser(authentication.getName()).getUserId();

        if (fileUpload.isEmpty()) {
            model.addAttribute("message", "EmptyFile");
        } else if (!fileService.isUniqueName(fileUpload.getOriginalFilename(), userId)) {
            model.addAttribute("message", "NotUniqueFileName");
            return "result";
        } else {
            fileService.addFile(new File(null, fileUpload.getOriginalFilename(), fileUpload.getContentType(), String.valueOf(fileUpload.getSize()), userId, fileUpload.getBytes()));
            model.addAttribute("message", "SuccessAddFile");
            return "result";
        }



        return "result";
    }

    @GetMapping("/download/{file_id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable(value = "file_id") Integer fileId) {

        ByteArrayResource resource = new ByteArrayResource(fileService.getFile(fileId).getFileData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileService.getFile(fileId).getFilename())
                .contentLength(fileService.getFile(fileId).getFileData().length)
                .body(resource);
    }

    @GetMapping("/delete/{file_id}")
    public String deleteFile(@PathVariable(value = "file_id") Integer fileId,Authentication authentication, Model model) {
        fileService.deleteFile(fileId);
        int userId = userService.getUser(authentication.getName()).getUserId();
        model.addAttribute("message", "SuccessDelFile");

        model.addAttribute("uploadedFiles", fileService.getAllFiles(userId));
        return "result";
    }

}

