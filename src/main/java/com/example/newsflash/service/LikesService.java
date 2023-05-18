package com.example.newsflash.service;

import com.example.newsflash.model.Likes;
import com.example.newsflash.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    @Autowired
    private final LikesRepository likesRepository;
    public List<Likes> getLikesByUserId(Long userId){
        return likesRepository.findByUserId(userId);
    }

    public Boolean getLikesByUserIdAndPostId(Long userId, Long postId){
        Boolean isLiked = likesRepository.getLikesByUserIdAndPostId(userId, postId);
        return isLiked != null ? isLiked : false;
    }

    public Boolean getDislikesByUserIdAndPostId(Long userId, Long postId){
        Boolean isDisliked = likesRepository.getDislikesByUserIdAndPostId(userId, postId);
        return isDisliked != null ? isDisliked : false;
    }

    public Long getTotalLikesByPostId(Long postId){
        return likesRepository.findTotalLikesByPostId(postId);
    }

    public Long getTotalDislikesByPostId(Long postId){
        return likesRepository.findTotalDislikesByPostId(postId);
    }

    public Likes getRowByUserIdAndPostId(Long userId, Long postId){
        Optional<Likes> likesOptional = likesRepository.getRowByUserIdAndPostId(userId, postId);
        return likesOptional.orElse(
                new Likes().builder()
                        .like(false)
                        .likedOn(null)
                        .dislike(false)
                        .dislikedOn(null)
                        .id(null)
                        .build()
        );
    }

    public Likes addLike(Likes likes){
        return likesRepository.save(likes);
    }

    public void deleteLike(Long id){
        likesRepository.deleteById(id);
    }
}
