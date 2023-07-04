package com.sparta.myblogspring1.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.myblogspring1.entity.Myblog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogResponseDto {
    private Long id;
    private String title;
    private String name;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public BlogResponseDto(Myblog myblog){
        this.id = myblog.getId();
        this.name = myblog.getName();
        this.contents = myblog.getContents();
        this.title = myblog.getTitle();
        this.createAt = myblog.getCreateAt();
        this.modifiedAt = myblog.getModifiedAt();
    }

}
