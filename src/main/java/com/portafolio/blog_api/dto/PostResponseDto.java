package com.portafolio.blog_api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private String authorUsername; 

        public Long getId() { 
        return id;
     }
    public void setId(Long id) { 
        this.id = id; 
    }
    public String getTitle() {
         return title;
         }
    public void setTitle(String title) { 
        this.title = title; 
    }
    public String getContent() { 
        return content;
     }
    public void setContent(String content) {
         this.content = content;
         }
    public LocalDateTime getCreationDate() { 
        return creationDate;
     }
    public void setCreationDate(LocalDateTime creationDate) { 
        this.creationDate = creationDate;
     }
    public String getAuthorUsername() { 
        return authorUsername; 
    }
    public void setAuthorUsername(String authorUsername) {
         this.authorUsername = authorUsername;
         }
}