package ru.naf4eg.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naf4eg.model.Student;
import ru.naf4eg.model.StudentNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @RequestMapping("/students")
    public List<Student> getStudents() {
        return Student.getStudents();
    }

    @RequestMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= Student.getStudents().size() || studentId < 0) {
            throw new StudentNotFoundException("Student is not found");
        }
        return Student.getStudents().get(studentId);
    }
}
