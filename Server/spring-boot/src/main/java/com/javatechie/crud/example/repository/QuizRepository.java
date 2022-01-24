package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Quiz;
import com.javatechie.crud.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    //Quiz findByName(String name);
}

