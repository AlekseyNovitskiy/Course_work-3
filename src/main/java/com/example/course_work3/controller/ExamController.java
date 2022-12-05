package com.example.course_work3.controller;

import com.example.course_work3.Question;
import com.example.course_work3.exception.UnSufficientQuestionsException;
import com.example.course_work3.service.ExaminerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    @ExceptionHandler(UnSufficientQuestionsException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.badRequest().body("Недостаточно вопросов");
    }

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }


    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
