package com.ptit.ptitexam.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long ansID;

    private String content;
    private Boolean isCorrect;
}
