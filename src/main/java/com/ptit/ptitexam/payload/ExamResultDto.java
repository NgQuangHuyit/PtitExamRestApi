package com.ptit.ptitexam.payload;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ExamResultDto {
    private Long id;

    private Time startTime;

    private Time endTime;

    private Float point;

    private ExamDto examDto;

    private List<SelectedAnswerDto> selectedAnswerDtos = new ArrayList<>() ;
}
