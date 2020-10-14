package com.amirghaffari.springcloud.demo.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable(name="id")long id ){
        return courseService.getCourse(id);
    }
}
