package com.example.mysqldumpangular.service;

import com.example.mysqldumpangular.model.Course;
import com.example.mysqldumpangular.model.CourseDTO;
import com.example.mysqldumpangular.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    private Course toEntity(CourseDTO courseDTO){
        return modelMapper.map(courseDTO,Course.class);
    }

    private CourseDTO toDTO(Course course){
        return modelMapper.map(course,CourseDTO.class);
    }

    @Override
    public CourseDTO findById(int id) {
        return toDTO(courseRepository.getOne(id));
    }

    @Override
    public List<CourseDTO> findAll() {
        List<CourseDTO> courseDTOList=new ArrayList<>();
        return courseRepository.findAll()
                 .stream()
                 .map(course -> {
                     courseDTOList.add(toDTO(course));
                     return toDTO(course);
                 })
                 .collect(Collectors.toList());
    }

    @Override
    public Course create(CourseDTO courseDTO) {
        return courseRepository.save(toEntity(courseDTO));
    }

    @Override @Transactional
    public CourseDTO update(int id,CourseDTO courseDTO) {
        Course old=courseRepository.getOne(id);
        old.setCategory(courseDTO.getCategory());
        old.setDescription(courseDTO.getDescription());
        old.setLessonsCount(courseDTO.getLessonsCount());
        old.setLongDescription(courseDTO.getLongDescription());
        old.setPrice(courseDTO.getPrice());
        old.setSeqNo(courseDTO.getSeqNo());
        old.setUrl(courseDTO.getUrl());
        return toDTO(old);
    }
}
