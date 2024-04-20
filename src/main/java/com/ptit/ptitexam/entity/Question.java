package com.ptit.ptitexam.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String content;

    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastModified;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "exam_id", updatable = false, nullable = false)
    private Exam exam;

    @PreUpdate
    public void updateLastModified() {
        this.lastModified = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    public void prePersist() {
        this.lastModified = new Timestamp(System.currentTimeMillis());
    }

    @PostPersist
    public void postPersist() {
        this.exam.updateQuestionCnt();
    }

    @PostRemove
    public void postRemove() {
        this.exam.updateQuestionCnt();
    }


}
