package com.example.eregistrar.service.impl;

import com.example.eregistrar.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import com.example.eregistrar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eregistrar.repository.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student updatedStudent = studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
//
//        LocalDate parseDate = LocalDate.parse(inputFormatter)
        updatedStudent.setStudentNumber(student.getStudentNumber());
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setMiddleName(student.getMiddleName());
        updatedStudent.setCgpa(student.getCgpa());
        updatedStudent.setDateOfEnrollment(student.getDateOfEnrollment());
        updatedStudent.setInternational(student.isInternational());

        return studentRepository.save(updatedStudent);
    }

    @Override
    public Student deleteStudent(int id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        studentRepository.deleteById(id);
        return student;
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found"));
    }


}
