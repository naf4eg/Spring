package ru.naf4eg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse {
    private int status;
    private String message;
    private String timestamp;
}
