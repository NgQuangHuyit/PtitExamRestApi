package com.ptit.ptitexam.payload;

import com.ptit.ptitexam.entity.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    private Long ansID;

    private String content;
    private Boolean isCorrect;
}
