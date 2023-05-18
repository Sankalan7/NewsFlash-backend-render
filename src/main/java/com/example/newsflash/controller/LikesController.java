package com.example.newsflash.controller;

import com.example.newsflash.model.Likes;
import com.example.newsflash.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikesController {
    @Autowired
    private final LikesService likesService;

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<List<Likes>> getLikesByUserId(@PathVariable("id") Long userId){
        List<Likes> likesList = likesService.getLikesByUserId(userId);
        return new ResponseEntity<>(likesList, HttpStatus.OK);
    }

    @GetMapping("/getLikesByUserIdAndPostId/{userId}/{postId}")
    public ResponseEntity<Boolean> getLikesByUserIdAndPostId(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){
        boolean isLiked = likesService.getLikesByUserIdAndPostId(userId, postId);
        return new ResponseEntity<>(isLiked, HttpStatus.OK);
    }

    @GetMapping("/getDislikesByUserIdAndPostId/{userId}/{postId}")
    public ResponseEntity<Boolean> getDislikesByUserIdAndPostId(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){
        boolean isDisliked = likesService.getDislikesByUserIdAndPostId(userId, postId);
        return new ResponseEntity<>(isDisliked, HttpStatus.OK);
    }

    @GetMapping("/getRowByUserIdAndPostId/{userId}/{postId}")
    public ResponseEntity<Likes> getRowByUserIdAndPostId(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId){
        Likes row = likesService.getRowByUserIdAndPostId(userId, postId);
        return new ResponseEntity<>(row, HttpStatus.OK);
    }

    @GetMapping("/getTotalLikesByPostId/{postId}")
    public ResponseEntity<Long> getTotalLikesByPostId(@PathVariable("postId") Long postId){
        Long totalLikes = likesService.getTotalLikesByPostId(postId);
        return new ResponseEntity<>(totalLikes, HttpStatus.OK);
    }

    @GetMapping("/getTotalDislikesByPostId/{postId}")
    public ResponseEntity<Long> getTotalDislikesByPostId(@PathVariable("postId") Long postId){
        Long totalDislikes = likesService.getTotalDislikesByPostId(postId);
        return new ResponseEntity<>(totalDislikes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Likes> addLike(@RequestBody Likes likes){
        Likes likes1 = likesService.addLike(likes);
        return new ResponseEntity<>(likes1, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteLike(@PathVariable("id") Long id){
        likesService.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
