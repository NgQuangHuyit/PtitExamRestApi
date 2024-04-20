package com.ptit.ptitexam.service;

import com.ptit.ptitexam.payload.AnswerDto;

import java.util.List;

public interface IAnswerService {
    List<AnswerDto> getAllByQuestionId(Long questionId);

    AnswerDto createAnswer(AnswerDto answerDto, Long questionId);

    AnswerDto updateAnswer(AnswerDto answerDto, Long answerId);

    void deleteAnswer(Long answerId);
}
