package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.payload.ApiResponse;
import com.ptit.ptitexam.payload.QuestionDto;
import com.ptit.ptitexam.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    // get all questions that belong to specific exam
    @GetMapping("/exams/{examID}/questions")
    public ResponseEntity<?> getQuestionByExam(@PathVariable("examID") Long examID) {
        return ResponseEntity.ok(questionService.getAllQuestionByExam(examID));
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping("/exams/{examID}/questions")
    public ResponseEntity<?> addQuestion(@PathVariable("examID") Long examID, @RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok(questionService.createQuestion(questionDto, examID));
    }

    @PutMapping("/questions/{quesId}")
    public ResponseEntity<?> updateQuestion(@PathVariable("quesId") Long quesId, @RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok(questionService.updateQuestion(quesId, questionDto));
    }

    @DeleteMapping("/questions/{quesId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("quesId") Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.ok(new ApiResponse("delete question with id" + questionId + "successful", true));
    }


}
