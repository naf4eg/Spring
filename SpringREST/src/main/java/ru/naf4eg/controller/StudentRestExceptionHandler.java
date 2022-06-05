package ru.naf4eg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.naf4eg.model.StudentErrorResponse;
import ru.naf4eg.model.StudentNotFoundException;

import java.util.Date;

@ControllerAdvice
public class StudentRestExceptionHandler {

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
