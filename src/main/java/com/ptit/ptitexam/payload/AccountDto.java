package com.ptit.ptitexam.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptit.ptitexam.entity.ExamResult;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 20, message = "username must be minium of 5 characters and maximum of 20 charactors")
    private String username;

    @NotEmpty
    @Size(min=8)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email(message = "Invalid Email")
    private String email;


    private String fullname;

    @Column(length = 20)
    private String classID;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 5)
    private String gender;

    private String phoneNumber;

    private Time lastLogin;



}
