package ru.vsharanov.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsharanov.student.entity.School;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findByName(String name);
}