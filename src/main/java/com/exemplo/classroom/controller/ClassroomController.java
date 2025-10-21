package com.exemplo.classroom.controller;

import com.exemplo.classroom.model.Classroom;
import com.exemplo.classroom.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@CrossOrigin(origins = "*")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping
    public List<Classroom> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getById(@PathVariable Long id) {
        Classroom classroom = service.findById(id);
        return (classroom != null) ? ResponseEntity.ok(classroom) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Classroom create(@RequestBody Classroom classroom) {
        return service.save(classroom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> update(@PathVariable Long id, @RequestBody Classroom classroom) {
        Classroom updated = service.update(id, classroom);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}