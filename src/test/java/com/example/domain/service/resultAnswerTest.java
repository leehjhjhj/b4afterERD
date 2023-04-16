package com.example.domain.service;

import com.example.domain.domain.AnswerStatus;
import com.example.domain.domain.Member;
import com.example.domain.domain.Question;
import com.example.domain.domain.Answer;
import com.example.domain.repository.AnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class resultAnswerTest {
    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void 유저생성() throws Exception {
        Member member = new Member(78);
        em.persist(member);
    }
    @Test
    @Rollback(value = false)
    public void 결과생성() throws Exception {
        Member member = em.find(Member.class, 1L);
        Question question = new Question(4L, "url.com", "김치");
        em.persist(question);
        Answer answer = Answer.createAnswer(question, member, "audio.com");
        answer.setAnswerStatus(AnswerStatus.INCORRECT);
        answerRepository.save(answer);
    }


}
