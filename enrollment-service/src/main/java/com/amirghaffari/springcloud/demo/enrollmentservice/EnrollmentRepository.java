package com.amirghaffari.springcloud.demo.enrollmentservice;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EnrollmentRepository {

    private static List<Enrollment> enrollments=List.of(
            new Enrollment(1, 1, 1, "A", "2019"),
            new Enrollment(2, 1, 2, "B", "2020"),
            new Enrollment(3, 1, 3, "A", "2020"),
            new Enrollment(4, 1, 4, "C", "2019"),

            new Enrollment(5, 2, 1, "B", "2019"),
            new Enrollment(6, 2, 2, "A", "2019"),
            new Enrollment(7, 2, 4, "B", "2020"),

            new Enrollment(8, 3, 2, "C", "2019"),
            new Enrollment(9, 3, 3, "B", "2019"),

            new Enrollment(10, 4, 3, "A", "2020")
    );

    public List <Enrollment> getEnrollmentsInYear(String year){
        return enrollments.stream().filter(
                e-> e.getYear().equals(year)
        ).collect(Collectors.toList());
    }

    public List<Enrollment> getEnrollmentsForStudent(long id){
        return enrollments.stream().filter(
                e-> e.getStudentId()==id
        ).collect(Collectors.toList());
    }
}
