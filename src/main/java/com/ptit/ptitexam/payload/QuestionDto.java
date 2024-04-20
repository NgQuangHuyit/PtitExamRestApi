package com.ptit.ptitexam.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String content;

    private String type;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp lastModified;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<AnswerDto>  answers = new ArrayList<>();

}
