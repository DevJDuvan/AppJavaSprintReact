package com.example.easynotes.controller;
import com.example.easynotes.model.Notebook;
import com.example.easynotes.model.Users;
import com.example.easynotes.repository.NotebookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class NotebookController {
   NotebookRepository notebookRepository;

    @GetMapping("/notebooks")
    public List<Notebook> getAllNotes() {
        return notebookRepository.findAll();
    }
    @GetMapping("/notebooksBystatusUser")
    public List<Notebook> getNotebookStatusUser(){
            List<Notebook> Notebooks = new ArrayList<Notebook>();
            notebookRepository.findByuserStatus().forEach(Users -> Notebooks.add(Users));
            return Notebooks;

    }
}
