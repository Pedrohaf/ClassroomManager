package com.exemplo.classroom.repository;

import com.exemplo.classroom.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Classroom, Long> {}