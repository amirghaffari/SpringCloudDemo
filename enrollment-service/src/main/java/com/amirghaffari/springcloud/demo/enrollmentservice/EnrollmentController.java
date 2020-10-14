package com.amirghaffari.springcloud.demo.enrollmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/year/{year}")
    public List<Enrollment> getEnrollmentsInYear(@PathVariable(name="year") String year){
        return enrollmentService.getEnrollmentsInYear(year);
    }

    @GetMapping("/student/{id}")
    public List<Enrollment> getEnrollmentsForStudent(@PathVariable(name="id") long id){
        return enrollmentService.getEnrollmentsForStudent(id);
    }
}
