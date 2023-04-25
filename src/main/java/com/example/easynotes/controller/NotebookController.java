package com.example.easynotes.controller;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Notebook;
import com.example.easynotes.model.Users;
import com.example.easynotes.repository.NotebookRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/notebooks")
    public Notebook createNotebook(@Valid @RequestBody Notebook notebooks) {
        return notebookRepository.save(notebooks);
    }
    @GetMapping("/notebooksBystatusUser")
    public List<Notebook> getNotebookStatusUser(){
            List<Notebook> Notebooks = new ArrayList<Notebook>();
            notebookRepository.findByuserStatus().forEach(notebook -> Notebooks.add(notebook));
            return Notebooks;

    }
}
