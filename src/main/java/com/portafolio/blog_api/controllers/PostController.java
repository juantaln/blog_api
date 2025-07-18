package com.portafolio.blog_api.controllers;

import com.portafolio.blog_api.entities.Post;
import com.portafolio.blog_api.services.PostService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/posts") 
public class PostController {

    @Autowired 
    private PostService postService;

   
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) { 
 
        if (post.getUser() == null || post.getUser().getId() == null) {
            
            return new ResponseEntity<>("El ID del usuario es requerido", HttpStatus.BAD_REQUEST);
        }
        Long userId = post.getUser().getId();
        
      
        Post newPost = postService.createPost(post, userId);
        
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) { 
    Optional<Post> postOptional = postService.getPostById(id);

   
    return postOptional
            .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));   
    }  
    
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
    return postService.updatePost(id, postDetails)
            .map(updatedPost -> new ResponseEntity<>(updatedPost, HttpStatus.OK)) 
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));  



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.deletePost(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        }
    }

}