package ru.vsharanov.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsharanov.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}