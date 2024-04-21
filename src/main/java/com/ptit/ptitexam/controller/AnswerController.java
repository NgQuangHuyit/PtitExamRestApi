package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.payload.AnswerDto;
import com.ptit.ptitexam.payload.ApiResponse;
import com.ptit.ptitexam.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/answers")
    public ResponseEntity<?> createAnswer(@RequestParam(name = "quesId", required = true) Long questionId, @RequestBody AnswerDto answerDto) {
        AnswerDto ans = answerService.createAnswer(answerDto, questionId);
        return ResponseEntity.ok(new ApiResponse<>("Answer was created successfully", true, ans));
    }

    @PutMapping("/answers")
    public ResponseEntity<?> updateAnswer(@RequestParam(name = "id", required = true) Long id, @RequestBody AnswerDto answerDto) {
        AnswerDto ans = answerService.updateAnswer(answerDto, id);
        return ResponseEntity.ok(new ApiResponse<>("Answer was updated successfully", true, ans));
    }

    @DeleteMapping("/answers")
    public ResponseEntity<?> deleteAnswer(@RequestParam(name = "id", required = true) Long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(new ApiResponse<>("Answer was deleted successfully", true, null), HttpStatus.OK);
    }
}
