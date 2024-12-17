package ru.vsharanov.student.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", sequenceName = "student_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Double score;

    @ManyToOne
    private Class aClass;

    public String getName() {
        return this.name;
    }

    public Double getScore() {
        return this.score;
    }
}
