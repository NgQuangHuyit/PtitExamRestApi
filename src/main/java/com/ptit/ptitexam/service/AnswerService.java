package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.Answer;
import com.ptit.ptitexam.entity.Question;
import com.ptit.ptitexam.exceptions.NotFoundException;
import com.ptit.ptitexam.payload.AnswerDto;
import com.ptit.ptitexam.repository.AnswerRepository;
import com.ptit.ptitexam.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AnswerDto> getAllByQuestionId(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new NotFoundException("question", "id", questionId));
        return answerRepository.findAllByQuestion(question).stream().map((ans) -> this.modelMapper.map(ans, AnswerDto.class)).toList();
    }

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new NotFoundException("question", "id", questionId));
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer.setQuestion(question);
        answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public AnswerDto updateAnswer(AnswerDto answerDto, Long answerId) {
        Answer ans = answerRepository.findById(answerId).orElseThrow(() -> new NotFoundException("answer", "id", answerId));
        ans.setContent(answerDto.getContent());
        ans.setIsCorrect(answerDto.getIsCorrect());
        answerRepository.save(ans);
        return modelMapper.map(ans, AnswerDto.class);
    }

    @Override
    public void deleteAnswer(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new NotFoundException("answer", "id", answerId));
        answerRepository.delete(answer);
    }

}
