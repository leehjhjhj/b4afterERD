package com.example.domain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.net.URL;

@Entity
@Getter @Setter
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;


    @Column(name = "image_url")
    private String imageUrl;

    private String answer;

    public Question(String imageUrl, String answer) {
        this.imageUrl = imageUrl;
        this.answer = answer;
    }
}
