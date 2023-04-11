package com.example.domain.service;

import com.example.domain.domain.Member;
import com.example.domain.domain.Question;
import com.example.domain.domain.Result;
import com.example.domain.repository.ResultRepository;
import com.example.domain.repository.ResultRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepositoryImpl resultRepository;

//    @Transactional
//    public void createResult(Question question, Member member, String audio) {
//        Result result = Result.createResult(question, member, audio);
//        resultRepository.save(result);
//    }

    public List<Result> findResult(Long memberId) {
        return resultRepository.findByMemberId(memberId);
    }
}
