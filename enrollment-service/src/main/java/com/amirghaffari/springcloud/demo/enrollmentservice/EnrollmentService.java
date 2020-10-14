package com.amirghaffari.springcloud.demo.enrollmentservice;

import com.amirghaffari.springcloud.demo.courseservice.Course;
import com.amirghaffari.springcloud.demo.enrollmentservice.client.CourseServiceClient;
import com.amirghaffari.springcloud.demo.enrollmentservice.client.StudentServiceClient;
import com.amirghaffari.springcloud.demo.studentservice.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final RestTemplate restTemplate;
    private final StudentServiceClient studentServiceClient;
    private final CourseServiceClient courseServiceClient;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, RestTemplate restTemplate, StudentServiceClient studentServiceClient, CourseServiceClient courseServiceClient) {
        this.enrollmentRepository = enrollmentRepository;
        this.restTemplate = restTemplate;
        this.studentServiceClient = studentServiceClient;
        this.courseServiceClient = courseServiceClient;
    }

    public List<Enrollment> getEnrollmentsInYear(String year){
        List<Enrollment> list=enrollmentRepository.getEnrollmentsInYear(year);
        list.forEach( enroll->{
                            Student student=restTemplate.getForObject("http://student-service/students/"+enroll.getStudentId(), Student.class);
                            Course course=restTemplate.getForObject("http://course-service/courses/"+enroll.getCourseId(), Course.class);
                            enroll.setStudentName(student.getFirstName()+" "+ student.getLastName());
                            enroll.setCourseName(course.getName());
                         }
                 );
        return list;
    }

    public List<Enrollment> getEnrollmentsForStudent(long id){
        Student student=studentServiceClient.getStudent(id);
        List<Enrollment> list= enrollmentRepository.getEnrollmentsForStudent(id);
        list.forEach( enroll->{
                    Course course=courseServiceClient.getCourses(enroll.getCourseId());
                    enroll.setStudentName(student.getFirstName()+" "+ student.getLastName());
                    enroll.setCourseName(course.getName());
                }
        );
        return list;
    }
}
