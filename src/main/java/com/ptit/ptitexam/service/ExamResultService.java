package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.Exam;
import com.ptit.ptitexam.entity.ExamResult;
import com.ptit.ptitexam.entity.User;
import com.ptit.ptitexam.exceptions.NotFoundException;
import com.ptit.ptitexam.payload.ExamResultDto;
import com.ptit.ptitexam.payload.ExamResultSumary;
import com.ptit.ptitexam.repository.ExamRepository;
import com.ptit.ptitexam.repository.ExamResultRepository;
import com.ptit.ptitexam.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ExamResultService implements IExamResultService{
    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ExamResultSumary> getAllByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));
        List<ExamResult> examResultList = examResultRepository.findAllByUser(user);
        return examResultList.stream().map((result) -> this.modelMapper.map(result, ExamResultSumary.class)).toList();
    }

    @Override
    public List<ExamResultSumary> getAllByExam(Long examId) {
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new NotFoundException("Exam", "id", examId));
        List<ExamResult> examResultList = examResultRepository.findAllByExam(exam);
        return examResultList.stream().map((result) -> this.modelMapper.map(result, ExamResultSumary.class)).toList();
    }

    @Override
    public void deleteResult(Long examResultId) {
        ExamResult result = examResultRepository.findById(examResultId).orElseThrow(() -> new NotFoundException("ExamResult", "id", examResultId));
        examResultRepository.delete(result);
    }

    @Override
    public ExamResultDto createResult(Long userId, Long examId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", "id", userId));
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new NotFoundException("Exam", "id", examId));
        ExamResult examResult = new ExamResult();
        examResult.setUser(user);
        examResult.setExam(exam);
        examResult.setPoint(0f);
        examResult.setStartTime(new Timestamp(System.currentTimeMillis()));
        examResultRepository.save(examResult);
        return this.modelMapper.map(examResult, ExamResultDto.class);
    }

    @Override
    public ExamResultDto submitResult(Long examResultId) {
        ExamResult result = examResultRepository.findById(examResultId).orElseThrow(() -> new NotFoundException("ExamResult", "id", examResultId));
        result.setEndTime(new Timestamp(System.currentTimeMillis()));
        result.updatePoint();
        examResultRepository.save(result);
        return this.modelMapper.map(examResultRepository.save(result), ExamResultDto.class);
    }

    @Override
    public ExamResultDto getResult(Long id) {
        ExamResult result = examResultRepository.findById(id).orElseThrow(() -> new NotFoundException("ExamResult", "id", id));

        return this.modelMapper.map(result, ExamResultDto.class);
    }

}