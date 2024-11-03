package com.shikhar.NextStep.posts_service.service;

import com.shikhar.NextStep.posts_service.dto.PostCreateRequestDTO;
import com.shikhar.NextStep.posts_service.dto.PostDTO;
import com.shikhar.NextStep.posts_service.entity.Post;
import com.shikhar.NextStep.posts_service.exception.ResourceNotFoundException;
import com.shikhar.NextStep.posts_service.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PostDTO getPostById(Long postId) {
        log.debug("Retrieving post with ID: {}", postId);

        Post post = postsRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("No post with ID: " + postId));

        return modelMapper.map(post, PostDTO.class);
    }

    public List<PostDTO> getAllPostsByUserId(Long userId) {
        List<Post> posts = postsRepository.findByUserId(userId);
        return posts.stream()
                .map((element) -> modelMapper.map(element, PostDTO.class))
                .collect(Collectors.toList());
    }
}
