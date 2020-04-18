package com.example.mysqldumpangular.service;

import com.example.mysqldumpangular.model.Course;
import com.example.mysqldumpangular.model.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO findById(int id);
    List<CourseDTO> findAll();
    Course create(CourseDTO courseDTO);

    CourseDTO update(int id,CourseDTO courseDTO);

}
