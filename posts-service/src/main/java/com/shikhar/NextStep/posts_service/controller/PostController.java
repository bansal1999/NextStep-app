package com.shikhar.NextStep.posts_service.controller;

import com.shikhar.NextStep.posts_service.dto.PostCreateRequestDTO;
import com.shikhar.NextStep.posts_service.dto.PostDTO;
import com.shikhar.NextStep.posts_service.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO,
                                              HttpServletRequest httpServletRequest) {
        PostDTO createdPost = postsService.createPost(postCreateRequestDTO, 1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }



}
