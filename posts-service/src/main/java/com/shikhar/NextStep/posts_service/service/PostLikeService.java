package com.shikhar.NextStep.posts_service.service;

import com.shikhar.NextStep.posts_service.entity.PostLike;
import com.shikhar.NextStep.posts_service.exception.BadRequestException;
import com.shikhar.NextStep.posts_service.exception.ResourceNotFoundException;
import com.shikhar.NextStep.posts_service.repository.PostLikeRepository;
import com.shikhar.NextStep.posts_service.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostsRepository postsRepository;

    public void likePost(Long postId, Long userId) {
        boolean exists = postsRepository.existsById(postId);
        if (!exists) {
            throw new ResourceNotFoundException("Post " + postId + "is not found");
        }

        boolean alreadyLiked = postLikeRepository.existsByUserIdAndPostId(userId, postId);
        if (alreadyLiked) {
            throw new BadRequestException("Post " + postId + " already liked post");
        }

        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLikeRepository.save(postLike);
        log.info("Post with id: {} is liked", postId);


    }
}