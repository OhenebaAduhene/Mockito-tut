package com.example.springsecuritytut.controller;


import com.example.springsecuritytut.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class StudentController {

    ArrayList<Student> STUDENTS = new ArrayList<>(Arrays.asList(
            new Student(1, "Wisdom",100),
            new Student(2, "Aduhene", 200),
            new Student(3, "Nkoah", 300)
    ));


    @GetMapping("/stu")
    public List<Student> getStudentList(){

        return STUDENTS;
    }

    @PostMapping("/mgn/stu")
    public void addStudent(@RequestBody Student student){
        System.out.println("add: "+student.toString());
    }

    @PutMapping("/mgn/update")
    public void updateStudent(@RequestBody Student student){
        System.out.println("update: "+student.getId());
    }

    @DeleteMapping("/mgn/del")
    public void deleteStudent(@RequestBody Student student){
        System.out.println("delete: "+student.getId());
    }
}
