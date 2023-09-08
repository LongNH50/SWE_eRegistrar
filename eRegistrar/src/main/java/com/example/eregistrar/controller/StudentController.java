package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping(value = {"/", "/home"})
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/students")
    public ModelAndView retrieveAllStudents() {
        List<Student> students = studentService.findAll();
        ModelAndView model = new ModelAndView("students");
        model.addObject("studentsList", students);

        return model;

    }

    @GetMapping("/students/signup")
    public String handleStudentForm(Model model){

        model.addAttribute("student", new Student());
        return "studentForm2";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(Model model, @PathVariable int id){
        boolean isUpdate = true;
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("isUpdate", isUpdate);
        return "studentForm2";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @PostMapping("students/update/{id}")
    public String updateStudent(@ModelAttribute Student student, Model model, @PathVariable int id){
        model.addAttribute("student", student);
        studentService.updateStudent(id, student);
        return "redirect:/students/signup";
    }

    @PostMapping("/students/remove/{id}")
    public String deleteStudent(@ModelAttribute Student student, Model model, @PathVariable int id ){
        System.out.println("========================deleteStudent==============" + student);
        model.addAttribute("student", student);
        studentService.deleteStudent(id);
        return "redirect:/students";
    }





}
