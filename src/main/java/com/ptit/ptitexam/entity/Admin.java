package com.ptit.ptitexam.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70)
    private String name;

    @Column(unique = true, nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIME)
    private Time lastLoginTime;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Exam> exams;

}

