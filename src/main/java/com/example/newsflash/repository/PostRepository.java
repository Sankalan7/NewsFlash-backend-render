package com.example.newsflash.repository;


import com.example.newsflash.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOrderByCreatedOnAsc();
    List<Post> findByUserId(Long id);
}
