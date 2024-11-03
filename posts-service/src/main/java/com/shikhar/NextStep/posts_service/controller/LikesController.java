package com.shikhar.NextStep.posts_service.controller;

import com.shikhar.NextStep.posts_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId) {
        postLikeService.likePost(postId, 1L);
        // Replace 1L with the actual user ID
        return ResponseEntity.noContent().build();  // 204 No Content status code
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId) {
        postLikeService.unlikePost(postId, 1L);
        return ResponseEntity.noContent().build();
    }

}
