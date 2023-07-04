package com.sparta.myblogspring1.controller;

import com.sparta.myblogspring1.dto.BlogRequestDto;
import com.sparta.myblogspring1.dto.BlogResponseDto;
import com.sparta.myblogspring1.entity.Myblog;
import com.sparta.myblogspring1.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private final BlogService blogService;

    public Controller(BlogService blogService){
        this.blogService = blogService;
    }

    //게시글 게시
    @PostMapping("/myblog")
    public BlogResponseDto createMyblog(@RequestBody BlogRequestDto requestDto){
        return blogService.createMyblog(requestDto);
    }

    //전체 게시글 조회
    @GetMapping("/myblog")
    public List<BlogResponseDto> getMemos() {
        return blogService.getMyblogs();
    }

    //선택한 게시글 조회
    @GetMapping("/myblog/{id}")
    public Optional<Myblog> getMyblogById(@PathVariable Long id){
        return blogService.getMyblogById(id);
    }

    @PutMapping("/myblog/{id}")
    public BlogResponseDto updateMyblog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        return blogService.updateMyblog(id, requestDto);
    }

    @DeleteMapping("/myblog/{id}")
    public String deleteMyblog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        return blogService.deleteMyblog(id, requestDto);
    }
}
