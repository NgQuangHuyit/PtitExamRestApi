package com.ptit.ptitexam.payload;

import com.ptit.ptitexam.entity.Admin;
import com.ptit.ptitexam.entity.ExamResult;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {

    private Long id;

    private String title;

    private String description;

    private String subject;

    private Integer timeAmt;

    private Boolean isActive;

    private Time createdAt;

}
