package com.exemplo.classroom.repository;

import com.exemplo.classroom.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}