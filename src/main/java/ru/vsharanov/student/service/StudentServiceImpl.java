package ru.vsharanov.student.service;

import org.springframework.stereotype.Service;
import ru.vsharanov.student.entity.Class;
import ru.vsharanov.student.entity.School;
import ru.vsharanov.student.repositories.ClassRepository;
import ru.vsharanov.student.repositories.SchoolRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final SchoolRepository schoolRepository;
    private final ClassRepository classRepository;

    public StudentServiceImpl(SchoolRepository schoolRepository, ClassRepository classRepository) {
        this.schoolRepository = schoolRepository;
        this.classRepository = classRepository;
    }

    @Override
    public Map<String, Map<String, Double>> getSchoolInfo(String schoolName) {
        School school = schoolRepository.findByName(schoolName)
                .orElseThrow(() -> new RuntimeException("School with name " + schoolName + " not found"));
        Map<String, Map<String, Double>> result = new HashMap<>();
        school.getClasses().forEach(c -> result.put(getTeacherName(c), getStudents(c)));
        return result;
    }

    private String getTeacherName(Class aClass) {
        return aClass.getTeacher().getName();
    }

    private Map<String, Double> getStudents(Class aClass) {
        Map<String, Double> studentScores = new HashMap<>();
        aClass.getStudents().forEach(s -> studentScores.put(s.getName(), s.getScore()));
        return studentScores;
    }

    @Override
    public Map<String, Map<String, Double>> getSchoolInfoStream(String schoolName) {
        School school = schoolRepository.findByName(schoolName)
                .orElseThrow(() -> new RuntimeException("School with name " + schoolName + " not found"));
        return school.getClasses()
                .stream()
                .collect(Collectors.toMap(this::getTeacherName, this::getStudents));
    }

    @Override
    public List<String> getSchoolInfo(Map<String, Map<String, Double>> stringMapMap) {
        Collection<String> teacherNames = stringMapMap.keySet().stream().toList();
        List<String> result = new ArrayList<>();
        classRepository.findByTeacher_NameInOrderByClassNameAsc(teacherNames).forEach(c -> result.add(c.getClassName()));
        return result;
    }

    @Override
    public List<String> getSchoolInfoStream(Map<String, Map<String, Double>> stringMapMap) {
        Collection<String> teacherNames = stringMapMap.keySet().stream().toList();
        return classRepository.findByTeacher_NameInOrderByClassNameAsc(teacherNames)
                .stream()
                .map(Class::getClassName)
                .toList();
    }
}