package com.ptit.ptitexam.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Temporal(TemporalType.TIME)
    private Time lastlogintime;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Exam> exams;

}

