package com.example.domain.dto;

import com.example.domain.domain.AnswerStatus;
import com.example.domain.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class ResultResponseDto {
    private List<Result> result;
    private int score;

    public int calculateScore(List<Result> results) {
        for (Result result : results) {
            if (result.getAnswerStatus() == AnswerStatus.CORRECT) {
                score += 1;
            }
        }
        return score;
    }

    public ResultResponseDto(List<Result> result) {
        this.result = result;
        this.score = calculateScore(result);
    }

}
