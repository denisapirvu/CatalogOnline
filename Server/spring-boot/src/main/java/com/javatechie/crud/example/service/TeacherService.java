package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Teacher;
import com.javatechie.crud.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public List<Teacher> saveTeachers(List<Teacher> teachers) {
        return repository.saveAll(teachers);
    }

    public List<Teacher> getTeachers() {
        return repository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Teacher getTeacherByName(String name) {
        return repository.findByName(name);
    }

    public String deleteTeacher(int id) {
        repository.deleteById(id);
        return "Teacher removed !! " + id;
    }

    public Teacher updateTeacher(Teacher teacher) {
        Teacher existingTeacher = repository.findById(teacher.getId_Teacher()).orElse(null);
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setSurname(teacher.getSurname());
        existingTeacher.setUsername(teacher.getUsername());
        existingTeacher.setPassword(teacher.getPassword());

        return repository.save(existingTeacher);
    }


}
