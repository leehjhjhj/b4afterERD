package com.example.domain.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private int age;
    private LocalDateTime createAt;

    public Member(int age) {
        this.age = age;
        this.createAt = LocalDateTime.now();
    }
    // 데이터가 없는 경우가 있음
    public double getAverage() {
        double average = 0.0;
        if ((this.age >= 55) && (this.age < 65)) {
            average = 12.37;
        } else if ((this.age >= 65) && (this.age < 75)) {
            average = 11.17;
        } else if ((this.age >= 75) && (this.age < 85)) {
            average = 10.50;
        } else if ((this.age >= 85) && (this.age < 95)) {
            average = 6.64;
        }
        return average;
    }
}

