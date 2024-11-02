package com.shikhar.NextStep.posts_service.service;

import com.shikhar.NextStep.posts_service.dto.PostCreateRequestDTO;
import com.shikhar.NextStep.posts_service.dto.PostDTO;
import com.shikhar.NextStep.posts_service.entity.Post;
import com.shikhar.NextStep.posts_service.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;

    public PostDTO createPost(PostCreateRequestDTO postCreateRequestDTO, Long userId) {
        Post post = modelMapper.map(postCreateRequestDTO, Post.class);
        post.setUserId(userId);

        Post savedPost = postsRepository.save(post);
        return modelMapper.map(savedPost, PostDTO.class);

    }
}
