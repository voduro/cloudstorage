package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {

    private final NoteMapper noteMapper;
    private final UserMapper userMapper;

    public NoteService(NoteMapper noteMapper, UserMapper userMapper) {
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
    }

    public int addNote(NoteForm noteForm, String username) {

        return noteMapper.insertNote(new Note(null, userMapper.getUser(username).getUserId(),noteForm.getNoteTitle(), noteForm.getNoteDescription()));
    }

    public List<Note> getAllNotes(String username) {

        return noteMapper.getAllNotes(userMapper.getUser(username).getUserId());
    }

    public int deleteNote(Integer noteId) {
        return noteMapper.deleteNote(noteId);
    }

    public int updateNote(NoteForm noteForm, String username) {
        //Pull the user id from user table
        User user = userMapper.getUser(username);

        return noteMapper.updateNote(new Note(noteForm.getNoteId(), userMapper.getUser(username).getUserId(), noteForm.getNoteTitle(), noteForm.getNoteDescription()));
    }

    public Note getNote(Integer noteId) {
        return noteMapper.getNote(noteId);
    }
}


