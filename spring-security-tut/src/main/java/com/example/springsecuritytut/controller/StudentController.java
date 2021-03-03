package com.example.springsecuritytut.controller;


import com.example.springsecuritytut.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class StudentController {

    ArrayList<Student> STUDENTS = new ArrayList<>(Arrays.asList(
            new Student(1, "Wisdom",100),
            new Student(2, "Aduhene", 200),
            new Student(3, "Nkoah", 300)
    ));


    @GetMapping("/stu/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE','ROLE_STUDENT')")
    public List<Student> getStudentList(@PathVariable("id") int id){

        return STUDENTS.stream()
                .filter(userId -> userId.getId() == id)
                .collect(Collectors.toList());
    }

    @PostMapping("/mgn/stu")
    @PreAuthorize("hasAuthority('course:write')")
    public void addStudent(@RequestBody Student student){
        System.out.println("add: "+student.toString());
    }

    @PutMapping("/mgn/update")
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@RequestBody Student student){
        System.out.println("update: "+student.getId());
    }

    @DeleteMapping("/mgn/del")
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@RequestBody Student student){
        System.out.println("delete: "+student.getId());
    }
}
