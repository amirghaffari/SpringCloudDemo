package com.amirghaffari.springcloud.demo.studentservice;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private static List<Student> students=List.of(
            new Student(1, "Amir", "Ghaffari", true),
            new Student(2, "Dan", "Star", true),
            new Student(3, "Marry", "Steel", true),
            new Student(4, "Jeff", "Brown", false)
    );

    public List <Student> getStudents(){
        return students;
    }

    public Optional<Student> getStudent(long id){
        return students.stream().filter(
                s-> s.getId()==id
        ).findAny();
    }
}
