package com.sparta.myblogspring1.repository;

import com.sparta.myblogspring1.entity.Myblog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Myblog,Long> {

    List<Myblog> findAllByOrderByModifiedAtDesc();
    Optional<Myblog> findById(Long id);

}