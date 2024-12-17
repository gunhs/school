package ru.vsharanov.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vsharanov.student.entity.Class;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query("select s from Class s where s.teacher.name in ?1 order by s.className")
    List<Class> findByTeacher_NameInOrderByClassNameAsc(Collection<String> names);
}