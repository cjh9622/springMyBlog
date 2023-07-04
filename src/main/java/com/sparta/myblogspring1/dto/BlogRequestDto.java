package com.sparta.myblogspring1.dto;

import lombok.Getter;

@Getter

public class BlogRequestDto {
    private String title;
    private String name;
    private String content;
    private int password;
}
