package com.example.domain.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URL;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Result {
    @Id @GeneratedValue
    @Column(name = "result_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private AnswerStatus answerStatus;

    private String audio;

    public static Result createResult(Question question, Member member, String audio) {
        Result result = new Result();
        result.setQuestion(question);
        result.setMember(member);
        result.setAudio(audio);
        result.setAnswerStatus(AnswerStatus.WAITING);
        return result;
    }

}
