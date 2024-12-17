package ru.vsharanov.student.entity;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_generator")
    @SequenceGenerator(name = "teacher_generator", sequenceName = "teacher_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public String getName() {
        return this.name;
    }
}