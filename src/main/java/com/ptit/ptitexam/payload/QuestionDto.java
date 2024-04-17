package com.ptit.ptitexam.payload;

import com.ptit.ptitexam.entity.Answer;
import com.ptit.ptitexam.entity.Exam;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private Long id;

    private String content;

    private String type;

    private Time lastModified;

    private List<AnswerDto>  answers = new ArrayList<>();

}
