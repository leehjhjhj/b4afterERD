package com.example.domain.repository;

import com.example.domain.domain.Answer;

import java.util.List;

public interface AnswerRepository {
    void save(Answer answer);

    List<Answer> findByMemberId(Long memberID);

}
