package com.exemplo.classroom.controller;

import com.exemplo.classroom.model.Reserva;
import com.exemplo.classroom.repository.ReservaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
