package com.example.newsflash.controller;

import com.example.newsflash.model.Comments;
import com.example.newsflash.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentsController {
    private final CommentsService commentsService;
    @GetMapping("/getByPostId/{id}")
    public ResponseEntity<List<Comments>> getCommentsByPostId(@PathVariable("id") Long id){
        List<Comments> comments = commentsService.getCommentsByPostId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Comments> addComment(@RequestBody Comments comments){
        Comments comments1 = commentsService.addComment(comments);
        return new ResponseEntity<Comments>(comments1, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable("id") Long id, @RequestBody Comments comments){
        Comments existingComment = commentsService.findCommentById(id);
        if (existingComment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingComment.setComment(comments.getComment());
        existingComment.setParentId(comments.getParentId());
        existingComment.setPostId(comments.getPostId());
        existingComment.setUserId(comments.getUserId());;
        Comments updatedComment = commentsService.updateComment(existingComment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        commentsService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
