package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FileService {

    //sttatch file mapper to service
    private final FileMapper fileMapper;


    //constructor
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    //methods

    public int addFile(File file) {
        //return the newley inserted file
        return fileMapper.insertFile(file);
    }

    public List<File> getAllFiles(Integer userId) {
        //return all uploaded files for that user
        return fileMapper.getAllFiles(userId);
    }

    public void deleteFile(Integer fileId) {
        //delete file at this given index
        fileMapper.deleteFile(fileId);
    }

    public File getFile(Integer fileId){
        //download the file at the given index
        return fileMapper.getFile(fileId);
    }

    public Boolean isUniqueName(String fileName, Integer userId) {
        List<File> files = getAllFiles(userId);
        return !files.stream().anyMatch(it -> it.getFilename().equals(fileName));
    }
}
