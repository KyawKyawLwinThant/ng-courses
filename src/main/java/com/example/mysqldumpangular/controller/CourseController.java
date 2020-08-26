package com.example.mysqldumpangular.controller;

import com.example.mysqldumpangular.model.Course;
import com.example.mysqldumpangular.model.CourseDTO;
import com.example.mysqldumpangular.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
    @CrossOrigin
    @PatchMapping(value="/courses/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDTO> update(@PathVariable int id,@RequestBody CourseDTO courseDTO){
        System.out.println("From CourseController:"+ id);
        return new ResponseEntity<CourseDTO>(courseService.update(id,courseDTO),HttpStatus.OK);
    }

    @GetMapping("/courses")
    public List<CourseDTO> findAll(){
        System.out.println("test 1");
        return courseService.findAll();
    }
}
