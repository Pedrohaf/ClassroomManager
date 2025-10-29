package com.exemplo.classroom.controller;

import com.exemplo.classroom.model.Classroom;
import com.exemplo.classroom.repository.ClassroomRepository;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/classrooms")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class ClassroomController {

    private static final Logger log = LoggerFactory.getLogger(ClassroomController.class);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSala(@PathVariable Long id) {
        log.info("DELETE /api/classrooms/{} chamado", id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            log.info("Sala {} removida", id);
            return ResponseEntity.noContent().build();
        }
        log.warn("Sala {} não encontrada", id);
        return ResponseEntity.notFound().build();
    }
}