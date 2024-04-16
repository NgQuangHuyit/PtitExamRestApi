package com.ptit.ptitexam.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.TIME)
    private Time createdAt;

    private Boolean isActive;

    @Embedded
    private AccountInfo accountInfo;

    @Temporal(TemporalType.TIME)
    private Time lastLogin;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<ExamResult> ExamResults;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Time(System.currentTimeMillis());
    }

}
