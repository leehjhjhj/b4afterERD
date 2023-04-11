package com.example.domain.service;

import com.example.domain.domain.Member;
import com.example.domain.domain.Question;
import com.example.domain.domain.Result;
import com.example.domain.repository.ResultRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class resultServiceTest {
    @Autowired
    ResultService resultService;
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void 결과생성() throws Exception {
        Member member = new Member(66);
        Question question = new Question("url.com", "정답");
        Result result = Result.createResult(question, member, "audio.com");
        resultRepository.save(result);
    }

}
