package com.portafolio.blog_api.repositories;

import com.portafolio.blog_api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PostRepository extends JpaRepository<Post, Long> { 
    
}
