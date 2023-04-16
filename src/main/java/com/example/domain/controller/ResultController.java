package com.example.domain.controller;

import com.example.domain.domain.Answer;
import com.example.domain.dto.AnswerResponseDto;
import com.example.domain.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ResultController {
    private final AnswerService answerService;
    @GetMapping("/result/{memberId}")
    public ResponseEntity<AnswerResponseDto> getResultsByMemberId(@PathVariable Long memberId) {
        List<Answer> answers = answerService.findResult(memberId);
        AnswerResponseDto response = new AnswerResponseDto(answers);
        return ResponseEntity.ok().body(response);
    }

}
