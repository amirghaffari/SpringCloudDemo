package com.amirghaffari.springcloud.demo.enrollmentservice.client;

import com.amirghaffari.springcloud.demo.courseservice.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("COURSE-SERVICE")
public interface CourseServiceClient {
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    Course getCourses(@RequestParam(name = "id", required = true) long id);
}
