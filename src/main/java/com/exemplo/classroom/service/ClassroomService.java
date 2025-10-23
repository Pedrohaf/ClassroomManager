package com.exemplo.classroom.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.exemplo.classroom.repository.ClassroomRepository; // <-- adicionado
// ...existing code...
@Service
public class ClassroomService {

    private final ClassroomRepository repository;

    @Autowired
    public ClassroomService(ClassroomRepository repository) {
        this.repository = repository;
    }

    // ... resto do código
}
