package com.shikhar.NextStep.posts_service.repository;

import com.shikhar.NextStep.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
