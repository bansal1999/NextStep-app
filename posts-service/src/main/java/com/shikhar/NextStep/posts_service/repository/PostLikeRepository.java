package com.shikhar.NextStep.posts_service.repository;

import com.shikhar.NextStep.posts_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);
}
