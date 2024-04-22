package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.ExamResult;
import com.ptit.ptitexam.entity.Question;
import com.ptit.ptitexam.entity.Answer;
import com.ptit.ptitexam.exceptions.CommonException;
import com.ptit.ptitexam.exceptions.NotFoundException;
import com.ptit.ptitexam.exceptions.ResouceAlreadyExists;
import com.ptit.ptitexam.payload.AnswerDto;
import com.ptit.ptitexam.payload.request.SelectAnswerRequest;
import com.ptit.ptitexam.repository.ExamResultRepository;
import com.ptit.ptitexam.repository.QuestionRepository;
import com.ptit.ptitexam.repository.AnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDto createSelectedAnswer(SelectAnswerRequest selectAnswerRequest, Long resultId){
        Question question = questionRepository.findById(selectAnswerRequest.getQuestion_id())
                .orElseThrow(() -> new NotFoundException("Question", "id", selectAnswerRequest.getQuestion_id()));
        ExamResult result = examResultRepository.findById(resultId)
                .orElseThrow(() -> new NotFoundException("ExamResult", "id", resultId));
        if (answerRepository.existsByQuestionAndExamResult(question, result))
            throw new ResouceAlreadyExists("Answer for question #"+ question.getId().toString() + " and result #" + result.getId().toString() + "already exists!");
        if (!result.getExam().getQuestions().contains(question))
            throw new CommonException("Exam doesn't contain question #"+ question.getId().toString() + "!");
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setExamResult(result);
        answer.setSelectedChoice(selectAnswerRequest.getSelected_choice());;
        return modelMapper.map(answerRepository.save(answer), AnswerDto.class);
    }


}
