package com.sparta.myblogspring1.entity;

import com.sparta.myblogspring1.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "myblog")
@NoArgsConstructor

public class Myblog extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "title", nullable = false, length = 300)
    private String title;
    @Column(name = "password")
    private int password;

    public Myblog(BlogRequestDto requestDto){
        this.name = requestDto.getName();
        this.contents = requestDto.getName();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(BlogRequestDto requestDto){
        this.name = requestDto.getName();
        this.contents = requestDto.getContent();
        this.title = requestDto.getTitle();
    }

}
