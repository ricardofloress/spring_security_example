package com.axis.axis_hotels_api.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/management/api/v1/student")
public class StudentManagementController {
    private final static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ricardo"),
            new Student(2, "Daniel"),
            new Student(3, "Amaury")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Register Student");
        System.out.println(student);

    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        System.out.println("Delete Student");
        System.out.println(id);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateStudent(@PathVariable("studentId") Integer id, @RequestBody Student student) {
        System.out.println("Update Student");
        System.out.println(String.format("%s %s", id, student));
    }
}
