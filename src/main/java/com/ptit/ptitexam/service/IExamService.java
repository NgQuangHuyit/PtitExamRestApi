package com.ptit.ptitexam.service;

import com.ptit.ptitexam.payload.ExamDto;

import java.util.List;

public interface IExamService {
    List<ExamDto> getAll();

    ExamDto getById(Long id);

    ExamDto createExam(ExamDto examDto, Long adminId);

    List<ExamDto> filterExams(Boolean status, String subject);

    List<ExamDto> searchExamsByTitle(String title);

    ExamDto updateExam(Long id, ExamDto examDto);

    void deleteExam(Long id);
}
