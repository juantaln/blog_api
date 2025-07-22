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
}