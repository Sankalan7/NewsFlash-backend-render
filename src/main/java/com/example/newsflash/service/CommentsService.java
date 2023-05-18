package com.example.newsflash.service;

import com.example.newsflash.model.Comments;
import com.example.newsflash.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    public Comments findCommentById(Long id){
        Optional<Comments> commentsOptional = commentsRepository.findById(id);
        return commentsOptional.orElse(null);
    }
    public List<Comments> getCommentsByPostId(Long postId){
        return commentsRepository.findCommentsByPostId(postId);
    }
    public Comments addComment(Comments comments){
        return commentsRepository.save(comments);
    }
    public Comments updateComment(Comments comments){
        return commentsRepository.save(comments);
    }
    public void deleteCommentById(Long id){
        commentsRepository.deleteById(id);
    }
}
