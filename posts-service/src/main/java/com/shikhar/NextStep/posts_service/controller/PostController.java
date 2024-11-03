package com.shikhar.NextStep.posts_service.controller;

import com.shikhar.NextStep.posts_service.dto.PostCreateRequestDTO;
import com.shikhar.NextStep.posts_service.dto.PostDTO;
import com.shikhar.NextStep.posts_service.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO,
                                              HttpServletRequest httpServletRequest) {
        PostDTO createdPost = postsService.createPost(postCreateRequestDTO, 1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long postId) {
        PostDTO postDTO = postsService.getPostById(postId);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDTO>> getAllPostsByUserId(@PathVariable Long userId) {
        // Implement logic to fetch all posts by the given user ID
        // Return the list of PostDTOs
        List<PostDTO> posts = postsService.getAllPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }

}
