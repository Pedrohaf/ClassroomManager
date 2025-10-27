package com.exemplo.classroom.controller;

import com.exemplo.classroom.model.Classroom;
import com.exemplo.classroom.repository.ClassroomRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class ClassroomController {

    private final ClassroomRepository repository;

    public ClassroomController(ClassroomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Classroom> listarSalas() {
        return repository.findAll();
    }

    @PostMapping
    public Classroom criarSala(@RequestBody Classroom classroom) {
        return repository.save(classroom);
    }
}