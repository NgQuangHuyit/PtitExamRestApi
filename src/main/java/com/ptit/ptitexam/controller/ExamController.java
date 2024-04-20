package com.ptit.ptitexam.controller;


import com.ptit.ptitexam.payload.ApiResponse;
import com.ptit.ptitexam.payload.ExamDto;
import com.ptit.ptitexam.service.ExamServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamServiceImpl examService;

    @GetMapping("/exams")
    public ResponseEntity<?> getAllExams() {
        List<ExamDto> exams = examService.getAll();
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<?> getExamById(@PathVariable(required = true) Long id) {
        return ResponseEntity.ok(examService.getById(id));
    }

    @GetMapping("/exams/filter")
    public ResponseEntity<?> getExamsByFilter(
            @RequestParam(name = "status", defaultValue = "") Boolean status,
            @RequestParam(name = "subject", defaultValue = "") String subject) {
        return ResponseEntity.ok(examService.filterExams(status, subject));
    }

    @GetMapping("/exams/search")
    public ResponseEntity<?> searchExamsByTitle(
            @RequestParam(name = "searchValue", required = true, defaultValue = "") String searchValue) {
        return ResponseEntity.ok(examService.searchExamsByTitle(searchValue));
    }


    @PostMapping("/exams")
    public ResponseEntity<?> createExam(@RequestParam(name = "adminId", required = true) Long adminId, @RequestBody ExamDto examDto) {
        return ResponseEntity.ok(examService.createExam(examDto, adminId));
    }

    @PutMapping("/exams/{id}")
    public ResponseEntity<?> updateExam(@PathVariable(required = true) Long id, @RequestBody ExamDto examDto) {
        return ResponseEntity.ok(examService.updateExam(id, examDto));
    }

    @DeleteMapping("/exams/{id}")
    public ResponseEntity<?> deleteExam(@PathVariable(required = true) Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<>(new ApiResponse("Exam was deleted successfully", true), HttpStatus.OK);
    }
}
