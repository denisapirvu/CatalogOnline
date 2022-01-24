package com.javatechie.crud.example.controller;


import com.javatechie.crud.example.entity.Teacher;
import com.javatechie.crud.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {


    @Autowired
    private TeacherService service;

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return service.saveTeacher(teacher);
    }
    @PostMapping("/addTeachers")
    public List<Teacher> addTeachers(@RequestBody List<Teacher> teachers){
        return service.saveTeachers(teachers);
    }
    @GetMapping("/Teachers")
    public List<Teacher> findAllTeachers(){
        return service.getTeachers();
    }
    @GetMapping("/Teacher/{id_teacher}")
    public Teacher findTeacherById(@PathVariable int id_teacher){
        return service.getTeacherById(id_teacher);
    }
    @GetMapping("/Teacher/{name}")
    public Teacher findTeacherByName(@PathVariable String name){
        return service.getTeacherByName(name);
    }
    @PutMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return service.updateTeacher(teacher);
    }
    @DeleteMapping("/deleteTeacher/{id_teacher}")
    public String deleteTeacher(@PathVariable int id_teacher){
        return service.deleteTeacher(id_teacher);
    }

}
