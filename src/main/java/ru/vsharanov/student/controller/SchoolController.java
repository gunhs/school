package ru.vsharanov.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.vsharanov.student.service.StudentService;
import ru.vsharanov.student.service.TeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchoolController {

    private final StudentService studentService;
    private final TeacherService teacherService;

    public SchoolController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/school/{schoolName}")
    public ResponseEntity<Map<String, Map<String, Double>>> getTeachers(@PathVariable("schoolName") String schoolName) {
        return ResponseEntity.ok(studentService.getSchoolInfo(schoolName));
    }

    @GetMapping("/school/stream/{schoolName}")
    public ResponseEntity<Map<String, Map<String, Double>>> getTeachersFromStream(@PathVariable("schoolName") String schoolName) {
        return ResponseEntity.ok(studentService.getSchoolInfoStream(schoolName));
    }

    @GetMapping("/school/")
    public ResponseEntity<List<String>> getSchoolInfo() {
        return ResponseEntity.ok(studentService.getSchoolInfo(getRequest()));
    }

    @GetMapping("/school/stream/")
    public ResponseEntity<List<String>> getSchoolInfoFromStream() {
        return ResponseEntity.ok(studentService.getSchoolInfoStream(getRequest()));
    }

    private Map<String, Map<String, Double>> getRequest() {
        Map<String, Map<String, Double>> request = new HashMap<>();
        teacherService.getAllTeachers().forEach(s -> request.put(s.getName(), null));
        return request;
    }
}