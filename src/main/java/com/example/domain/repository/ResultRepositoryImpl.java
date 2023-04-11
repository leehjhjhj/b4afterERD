package com.example.domain.repository;

import com.example.domain.domain.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResultRepositoryImpl implements ResultRepository{

    private final EntityManager em;
    @Override
    public void save(Result result) {
        em.persist(result);
    }
    @Override
    public List<Result> findByMemberId(Long memberId) {
        return em.createQuery("select r from Result r where r.member.id = :memberId", Result.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
