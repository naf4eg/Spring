package ru.naf4eg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;

    public static List<Student> getStudents() {
        List<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("Kostya", "Li"));
        listStudents.add(new Student("Denis", "Malyutin"));
        listStudents.add(new Student("Andrey", "Fedun"));
        return listStudents;
    }
}
