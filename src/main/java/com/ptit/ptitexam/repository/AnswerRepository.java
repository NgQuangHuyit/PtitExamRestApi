package com.ptit.ptitexam.repository;

import com.ptit.ptitexam.entity.Answer;
import com.ptit.ptitexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);

    List<Answer> findAllByQuestion(Question question);
}
