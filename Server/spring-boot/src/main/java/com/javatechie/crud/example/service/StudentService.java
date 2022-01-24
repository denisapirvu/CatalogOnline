package com.javatechie.crud.example.service;


import com.javatechie.crud.example.entity.Student;

import com.javatechie.crud.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name) {
        return repository.findByName(name);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student removed !! ";
    }

    public Student updateStudent(Student student) {
        Student existingStudent = repository.findById(student.getId_student()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setGrupa(student.getGrupa());
        existingStudent.setSurname(student.getSurname());
    //    existingStudent.setUsername(student.getUsername());
      //  existingStudent.setPassword(student.getPassword());

        return repository.save(existingStudent);
    }


}
