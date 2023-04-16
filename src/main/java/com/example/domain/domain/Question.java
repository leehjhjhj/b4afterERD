package com.example.domain.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URL;

@Entity
@Getter
@NoArgsConstructor
public class Question {
    @Id
    @Column(name = "question_id")
    private Long id;


    @Column(name = "image_url")
    private String imageUrl;

    private String word;

    public Question(Long id, String imageUrl, String word) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.word = word;
    }
}
