package com.amirghaffari.springcloud.demo.courseservice;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    private static List<Course> courses=List.of(
            new Course(1, "Operating Systems", 3.0f, true),
            new Course(2, "Object Oriented Programming", 3.5f, true),
            new Course(3, "Algorithms & Data Structures", 3.0f, true),
            new Course(4, "Networking and Wireless", 2.5f, true)
    );

    public List<Course> getCourses(){
        return courses;
    }

    public Optional<Course> getCourse(long id){
        return courses.stream().filter(
                c-> c.getId()==id
        ).findAny();
    }
}
