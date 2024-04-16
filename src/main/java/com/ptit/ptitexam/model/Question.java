package com.ptit.ptitexam.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String type;

    @Temporal(TemporalType.TIME)

    private Time lastModified;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "exam_id", updatable = false, nullable = false)
    private Exam exam;
}
