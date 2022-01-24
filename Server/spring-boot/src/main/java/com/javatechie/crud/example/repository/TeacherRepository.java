package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByName(String name);
}