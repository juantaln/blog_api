package com.portafolio.blog_api.dto;


import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}