package ru.vsharanov.student.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map<String, Map<String, Double>> getSchoolInfo(String schoolName);

    Map<String, Map<String, Double>> getSchoolInfoStream(String schoolName);

    List<String> getSchoolInfo(Map<String, Map<String, Double>> stringMapMap);

    List<String> getSchoolInfoStream(Map<String, Map<String, Double>> stringMapMap);
}
