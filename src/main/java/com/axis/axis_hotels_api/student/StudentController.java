package com.axis.axis_hotels_api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ricardo"),
            new Student(2, "Daniel"),
            new Student(3, "Amaury")
    );


    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer id) {
        return STUDENTS
                .stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with that id does not exists"));
    }
}
