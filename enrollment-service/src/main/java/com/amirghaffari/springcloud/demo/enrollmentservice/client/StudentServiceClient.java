package com.amirghaffari.springcloud.demo.enrollmentservice.client;

import com.amirghaffari.springcloud.demo.studentservice.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("STUDENT-SERVICE")
public interface StudentServiceClient {
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student getStudent(@RequestParam(name = "id", required = true) long id);
}
