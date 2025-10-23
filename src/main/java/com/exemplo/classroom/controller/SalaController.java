package com.exemplo.classroom.controller;

import com.exemplo.classroom.model.Classroom;
import com.exemplo.classroom.repository.SalaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaRepository salaRepository;

    public SalaController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @GetMapping
    public List<Classroom> listar() {
        return salaRepository.findAll();
    }

    @PostMapping
    public Classroom criar(@RequestBody Classroom sala) {
        return salaRepository.save(sala);
    }
}
