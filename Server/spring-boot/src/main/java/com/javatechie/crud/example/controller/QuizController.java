package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Inregistrare;
import com.javatechie.crud.example.entity.Quiz;
import com.javatechie.crud.example.service.InregistrareService;
import com.javatechie.crud.example.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("/addQuiz")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return service.saveQuiz(quiz);
    }
    @PostMapping("/addQuizuri")
    public List<Quiz> addQuizuri(@RequestBody List<Quiz> quizuri){
        return service.saveQuizuri(quizuri);
    }
    @GetMapping("/Quizuri")
    public List<Quiz> findAllQuizuri(){
        return service.getQuizuri();
    }
    @GetMapping("/Quiz/{id_Quiz}")
    public Quiz findQuizById(@PathVariable int id_Quiz){
        return service.getQuizById(id_Quiz);
    }
    //  @GetMapping("/Quiz/{name}")
    //public Quiz findQuizByName(@PathVariable String name){
    //    return service.getQuizByName(name);
    //  }
    @PutMapping("/updateQuiz")
    public Quiz updateQuiz(@RequestBody Quiz Quiz){
        return service.updateQuiz(Quiz);
    }
    @DeleteMapping("/deleteQuiz/{id_Quiz}")
    public String deleteQuiz(@PathVariable int id_Quiz){
        return service.deleteQuiz(id_Quiz);
    }

}
