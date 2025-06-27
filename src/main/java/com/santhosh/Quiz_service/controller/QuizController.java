package com.santhosh.Quiz_service.controller;
import com.santhosh.Quiz_service.model.QuestionWrapper;
import com.santhosh.Quiz_service.model.QuizDto;
import com.santhosh.Quiz_service.model.Response;
import com.santhosh.Quiz_service.service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    Quizservice quizservice;
    @PostMapping("create")

    public ResponseEntity<String> createQuize(@RequestBody QuizDto quizDto) {

    return quizservice.createQuize(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());

    }
    @PostMapping("get/{id}")

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
       return quizservice.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizservice.calculateResult(id,responses);
    }


}
