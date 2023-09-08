package com.example.eregistrar;

import com.example.eregistrar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.eregistrar.repository.StudentRepository;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SpringBootApplication
//@ComponentScan(basePackages = "repository")
public class ERegistrarApplication implements CommandLineRunner {
//    @Autowired
//    public StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        formatter = formatter.withLocale(Locale.US);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse("2019/05/24", formatter);

//        Student student1 = new Student("000-61-0001", "Anna", "Lyn", "Smith", 3.45, date,true);
//        Student student2 = new Student("000-61-0002", "Aaron", "LLuynn", "Smith1", 2, date,true);
//        Student student3 = new Student("000-61-0003", "Lambd", "LyLy", "Smith2", 5, date,false);
//        Student student4 = new Student("000-61-0004", "Rambo", "Linh", "Smith3", 2, date, true);
//
//        saveStudent(student1);
//        saveStudent(student2);
//        saveStudent(student3);
//        saveStudent(student4);

    }

//    public Student saveStudent(Student student) {
//        return studentRepository.save(student);
//    }

}
