package ru.naf4eg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naf4eg.model.Student;
import ru.naf4eg.model.StudentErrorResponse;
import ru.naf4eg.model.StudentNotFoundException;

import java.util.Date;
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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date(System.currentTimeMillis()).toString());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(new Date(System.currentTimeMillis()).toString());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
