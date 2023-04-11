package com.example.domain.repository;

import com.example.domain.domain.Result;

import java.util.List;

public interface ResultRepository {
    void save(Result result);

    List<Result> findByMemberId(Long memberID);

}
