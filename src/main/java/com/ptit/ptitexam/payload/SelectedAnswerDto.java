package com.ptit.ptitexam.payload;

import com.ptit.ptitexam.entity.Answer;
import com.ptit.ptitexam.entity.ExamResult;
import com.ptit.ptitexam.entity.Question;
import jakarta.persistence.*;

public class SelectedAnswerDto {
    private Long id;


    private AnswerDto answer;

    private QuestionDto question;

}
