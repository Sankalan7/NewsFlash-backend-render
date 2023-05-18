package com.example.newsflash.repository;

import com.example.newsflash.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserId(Long id);

    @Query("SELECT COALESCE(SUM(CASE WHEN t.like = true THEN 1 ELSE 0 END), 0) from Likes t WHERE t.postId = ?1")
    Long findTotalLikesByPostId(Long postId);

    @Query("SELECT COALESCE(SUM(CASE WHEN t.dislike = true THEN 1 ELSE 0 END), 0) from Likes t WHERE t.postId = ?1")
    Long findTotalDislikesByPostId(Long postId);

    @Query("SELECT COALESCE(t.like, false) FROM Likes t WHERE t.userId = ?1 AND t.postId = ?2")
    Boolean getLikesByUserIdAndPostId(Long userId, Long postId);

    @Query("SELECT COALESCE(t.dislike, false) FROM Likes t WHERE t.userId = ?1 AND t.postId = ?2")
    Boolean getDislikesByUserIdAndPostId(Long userId, Long postId);

    @Query("SELECT t from Likes t WHERE t.userId = ?1 AND t.postId = ?2")
    Optional<Likes> getRowByUserIdAndPostId(Long userId, Long postId);
}
