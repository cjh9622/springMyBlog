package com.sparta.myblogspring1.service;

import com.sparta.myblogspring1.dto.BlogRequestDto;
import com.sparta.myblogspring1.dto.BlogResponseDto;
import com.sparta.myblogspring1.entity.Myblog;
import com.sparta.myblogspring1.repository.BlogRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(ApplicationContext context) {
        BlogRepository blogRepository = context.getBean(BlogRepository.class);
        this.blogRepository = blogRepository;
    }

    public BlogResponseDto createMyblog(BlogRequestDto requestDto){
        Myblog myblog = new Myblog(requestDto);
        Myblog saveMyblog = blogRepository.save(myblog);

        return new BlogResponseDto(saveMyblog);
    }

    public List<BlogResponseDto> getMyblogs() {
        return blogRepository.findAllByOrderByModifiedAtDesc().stream().map(BlogResponseDto::new).toList();
    }

    public Optional<Myblog> getMyblogById(Long id) {
        return blogRepository.findById(id);
    }

    @Transactional
    public BlogResponseDto updateMyblog(Long id, BlogRequestDto requestDto){
        Myblog myblog = findMyblog(id);
        if(checkPassword(myblog.getPassword(), requestDto.getPassword())){
            myblog.update(requestDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다");
        }

        return new BlogResponseDto(myblog);
    }

    public String deleteMyblog(Long id, BlogRequestDto requestDto){
        Myblog myblog = findMyblog(id);
        if(myblog.getPassword()==requestDto.getPassword()){
            blogRepository.delete(myblog);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다");
        }
        return "Success";
    }

    private boolean checkPassword(int a, int b){
        return a==b;
    }

    private Myblog findMyblog(Long id) {
        return blogRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "게시글이 존재하지 않습니다")
        );
    }


}
