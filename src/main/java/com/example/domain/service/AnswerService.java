package com.example.domain.service;

import com.example.domain.domain.Member;
import com.example.domain.domain.Question;
import com.example.domain.domain.Answer;
import com.example.domain.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Transactional
    public void createAnswer(Question question, Member member, String audio) {
        Answer answer = Answer.createAnswer(question, member, audio);
        answerRepository.save(answer);
    }

    public List<Answer> findResult(Long memberId) {
        return answerRepository.findByMemberId(memberId);
    }


}
