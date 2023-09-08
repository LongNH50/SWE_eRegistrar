package com.example.eregistrar.service;

import com.example.eregistrar.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student addStudent(Student student);

    Student updateStudent(int id, Student student);

    Student deleteStudent(int id);

    Student findStudentById(int id);
}
