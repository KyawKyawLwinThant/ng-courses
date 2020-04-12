package com.example.mysqldumpangular.controller;

import com.example.mysqldumpangular.model.Course;
import com.example.mysqldumpangular.model.CourseDTO;
import com.example.mysqldumpangular.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/courses",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO){
        this.courseService.create(courseDTO);
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public List<CourseDTO> findAll(){
        return courseService.findAll();
    }
}
