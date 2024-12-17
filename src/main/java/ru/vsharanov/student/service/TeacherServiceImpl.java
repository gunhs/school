package ru.vsharanov.student.service;

import org.springframework.stereotype.Service;
import ru.vsharanov.student.entity.Teacher;
import ru.vsharanov.student.repositories.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}