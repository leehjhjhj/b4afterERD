package com.example.domain.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private AnswerStatus answerStatus;

    private String audio;
    // 스태틱 생성 메소드
    public static Result createResult(Question question, Member member, String audio) {
        Result result = new Result();
        result.setQuestion(question);
        result.setMember(member);
        result.setAudio(audio);
        result.setAnswerStatus(AnswerStatus.BEFORE);
        return result;
    }

    public char getOX() {
        char outPutResult;
        if (this.answerStatus == AnswerStatus.CORRECT) {
            outPutResult = 'O';
        } else if (this.answerStatus == AnswerStatus.INCORRECT) {
            outPutResult = 'X';
        } else {
            outPutResult = '?';
        }
        return outPutResult;
    }

}
