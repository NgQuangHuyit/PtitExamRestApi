package com.ptit.ptitexam.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.sql.Date;


@Embeddable
@Data
public class AccountInfo {
    private String fullname;
    private String classID;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 5)
    private String gender;
    private String phoneNumber;

}
