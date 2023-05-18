package com.example.newsflash.repository;

import com.example.newsflash.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    @Query("SELECT t from Comments t WHERE t.postId = ?1")
    List<Comments> findCommentsByPostId(Long postId);
}
