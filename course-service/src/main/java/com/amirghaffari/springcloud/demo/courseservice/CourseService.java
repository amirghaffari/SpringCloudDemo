package com.amirghaffari.springcloud.demo.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(){
        return courseRepository.getCourses().stream().
                filter(c-> c.isActive()).collect(Collectors.toList());
    }

    public Course getCourse(long id){
        return courseRepository.getCourse(id).orElse(null);
    }
}
