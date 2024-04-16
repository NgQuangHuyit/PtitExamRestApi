package com.ptit.ptitexam.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;

    String description;

    String subject;

    int timeAmt;

    Boolean isActive;

    @Temporal(TemporalType.TIME)
    Time createdAt;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Admin admin;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<ExamResult> examResults;


}
