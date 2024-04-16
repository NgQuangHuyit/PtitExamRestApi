package com.ptit.ptitexam.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIME)
    private Time startTime;

    @Temporal(TemporalType.TIME)
    private Time endTime;

    private Integer point;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Account account;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Exam exam;

    @OneToMany(mappedBy = "examResult", cascade = CascadeType.ALL)
    private List<SelectedAnswer> selectedAnswers;

}
