package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping
    public String addNote(@ModelAttribute(value = "noteForm") NoteForm noteForm, Authentication authentication, Model model) {

        int userId = userService.getUser(authentication.getName()).getUserId();

        noteService.addNote(noteForm, authentication.getName());

        model.addAttribute("message", "SuccessAddNote");

        return "result";
    }

    @PostMapping("/edit/{note_id}")
    public String editNote(@PathVariable(value = "note_id") NoteForm noteForm, Authentication authentication, Model model) {

        noteService.updateNote(noteForm, authentication.getName());
        model.addAttribute("message", "SuccessUpdNote");

        return "result";
    }

    @GetMapping("/delete/{note_id}")
    public String deleteFile(@PathVariable(value = "note_id") Integer noteId, Model model) {
        noteService.deleteNote(noteId);
        model.addAttribute("message", "SuccessDelNote");

        return "result";
    }

}
