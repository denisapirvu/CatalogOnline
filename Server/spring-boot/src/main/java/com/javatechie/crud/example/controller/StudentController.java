package com.javatechie.crud.example.controller;


import com.javatechie.crud.example.entity.Student;
import com.javatechie.crud.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.saveStudents(students);
    }
    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return service.getStudents();
    }
    @GetMapping("/student/{id_student}")
    public Student findStudentById(@PathVariable int id_student){
        return service.getStudentById(id_student);
    }
    @GetMapping("/student/{name}")
    public Student findStudentByName(@PathVariable String name){
        return service.getStudentByName(name);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete/{id_student}")
    public String deleteStudent(@PathVariable int id_student){
        return service.deleteStudent(id_student);
    }

}
