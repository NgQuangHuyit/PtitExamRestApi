package com.ptit.ptitexam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SelectedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private ExamResult examResult;

}

