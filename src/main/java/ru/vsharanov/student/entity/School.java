package ru.vsharanov.student.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_generator")
    @SequenceGenerator(name = "school_generator", sequenceName = "school_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "school")
    private List<Class> classes;

    public String getName() {
        return this.name;
    }

    public List<Class> getClasses() {
        return this.classes;
    }
}