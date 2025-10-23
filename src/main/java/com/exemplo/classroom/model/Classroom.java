package com.exemplo.classroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer capacidade;
}