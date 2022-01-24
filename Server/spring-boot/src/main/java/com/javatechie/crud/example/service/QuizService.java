package com.javatechie.crud.example.service;


import com.javatechie.crud.example.entity.Quiz;
import com.javatechie.crud.example.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository repository;

    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> saveQuizuri(List<Quiz> quizuri) {
        return repository.saveAll(quizuri);
    }

    public List<Quiz> getQuizuri() {
        return repository.findAll();
    }

    public Quiz getQuizById(int id) {
        return repository.findById(id).orElse(null);
    }

    // public Quiz getQuizByName(String name) {
    //      return repository.findByName(name);
    //  }

    public String deleteQuiz(int id) {
        repository.deleteById(id);
        return "Quiz removed !! " + id;
    }

    public Quiz updateQuiz(Quiz quiz) {
        Quiz existingQuiz = repository.findById(quiz.getId_quiz()).orElse(null);
        existingQuiz.setData1(quiz.getData1());
        existingQuiz.setData2(quiz.getData2());
        existingQuiz.setData3(quiz.getData3());

        existingQuiz.setNr1(quiz.getNr1());
        existingQuiz.setNr2(quiz.getNr2());
        existingQuiz.setNr3(quiz.getNr3());

        return repository.save(existingQuiz);
    }


}
