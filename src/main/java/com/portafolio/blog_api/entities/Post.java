package com.portafolio.blog_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts") 
@Getter 
@Setter 
public class Post {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false) 
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") 
    private String content;

    private LocalDateTime creationDate;

    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist 
    public void onPrePersist() {
        creationDate = LocalDateTime.now();
    }
}