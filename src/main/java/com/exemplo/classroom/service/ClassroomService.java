package com.exemplo.classroom.service;

import com.exemplo.classroom.model.Classroom;
import com.exemplo.classroom.repository.ClassroomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassroomService {
    private final ClassroomRepository repository;

    public ClassroomService(ClassroomRepository repository) {
        this.repository = repository;
    }

    public List<Classroom> findAll() {
        return repository.findAll();
    }

    public Classroom findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Classroom save(Classroom classroom) {
        return repository.save(classroom);
    }

    public Classroom update(Long id, Classroom updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setCapacity(updated.getCapacity());
                    existing.setLocation(updated.getLocation());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
