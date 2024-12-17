package ru.vsharanov.student.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_generator")
    @SequenceGenerator(name = "class_generator", sequenceName = "class_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String className;

    @OneToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "aClass")
    private List<Student> students;

    @ManyToOne
    private School school;

    public String getClassName() {
        return this.className;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
