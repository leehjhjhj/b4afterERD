package com.example.domain.controller;

import com.example.domain.domain.Result;
import com.example.domain.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;
    @GetMapping("/result/{memberId}")
    public ResponseEntity<List<Result>> getResultsByMemberId(@PathVariable Long memberId) {
        List<Result> results = resultService.findResult(memberId);
        return ResponseEntity.ok().body(results);
    }

}
