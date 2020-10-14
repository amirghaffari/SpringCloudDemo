package com.amirghaffari.springcloud.demo.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.getStudents().stream().
                filter(s-> s.isActive()).collect(Collectors.toList());
    }

    public Student getStudent(long id){
        return studentRepository.getStudent(id).orElse(null);
    }
}
