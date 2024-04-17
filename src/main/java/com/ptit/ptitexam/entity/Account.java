package com.ptit.ptitexam.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    private Boolean isActive = true;

    private String fullname;

    @Column(length = 20)
    private String classID;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 5)
    private String gender;

    @Column(length = 15)
    private String phoneNumber;


    @Temporal(TemporalType.TIME)
    private Time lastLogin;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<ExamResult> ExamResults;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

}
