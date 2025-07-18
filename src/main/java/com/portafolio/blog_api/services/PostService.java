package com.portafolio.blog_api.services;

import com.portafolio.blog_api.entities.Post;
import com.portafolio.blog_api.entities.User;
import com.portafolio.blog_api.repositories.PostRepository;
import com.portafolio.blog_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository; 

  
    public Post createPost(Post post, Long userId) {
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));
        
     
        post.setUser(user);
        
       
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Post> updatePost(Long id, Post postDetails) {
        return postRepository.findById(id)
            .map(existingPost -> {
                existingPost.setTitle(postDetails.getTitle());
                existingPost.setContent(postDetails.getContent());
                return postRepository.save(existingPost);
            });
    }

    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}