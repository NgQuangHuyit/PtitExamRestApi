package com.ptit.ptitexam.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String subject;

    private Integer timeAmt;

    @Column()
    private Boolean isActive = true;

    @Temporal(TemporalType.TIME)
    Time createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Admin admin;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<ExamResult> examResults;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    List<Question> questions;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Time(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
