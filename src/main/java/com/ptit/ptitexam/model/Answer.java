package com.ptit.ptitexam.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ansID;

    private String content;
    private Boolean isCorrect;

    @ManyToOne()
    @JoinColumn(name = "questionID", updatable = false, nullable = false)
    private Question question;



}
