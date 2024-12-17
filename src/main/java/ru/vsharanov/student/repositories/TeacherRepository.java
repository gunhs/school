package ru.vsharanov.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsharanov.student.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}