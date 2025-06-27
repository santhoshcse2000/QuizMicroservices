package com.santhosh.Quiz_service.feign;

import com.santhosh.Quiz_service.model.QuestionWrapper;
import com.santhosh.Quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("Question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String CategoryName, @RequestParam Integer numberofQuestion);
    @PostMapping("Question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFormId(@RequestBody List<Integer> questionId);
    @PostMapping("Question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
