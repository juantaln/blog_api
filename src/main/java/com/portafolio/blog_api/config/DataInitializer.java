package com.portafolio.blog_api.config;

import com.portafolio.blog_api.entities.Post;
import com.portafolio.blog_api.entities.User;
import com.portafolio.blog_api.repositories.PostRepository;
import com.portafolio.blog_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @Override
    public void run(String... args) throws Exception {
        
        if (userRepository.count() == 0) {
            System.out.println("No se encontraron usuarios. Creando datos de ejemplo...");

            
            User exampleUser = new User();
            exampleUser.setUsername("autor_ejemplo");
           
            exampleUser.setPassword(passwordEncoder.encode("password123"));
            userRepository.save(exampleUser);

            Post post1 = new Post();
            post1.setTitle("Bienvenida al Blog");
            post1.setContent("Este es el primer post, generado automáticamente.");
            post1.setCreationDate(LocalDateTime.parse("2025-07-14T10:00:00"));
            post1.setUser(exampleUser);

            Post post2 = new Post();
            post2.setTitle("¿Qué es Spring Boot?");
            post2.setContent("Spring Boot es un framework que facilita la creación de aplicaciones Java.");
            post2.setCreationDate(LocalDateTime.parse("2025-07-14T10:05:00"));
            post2.setUser(exampleUser);

            Post post3 = new Post();
            post3.setTitle("Sobre las API REST");
            post3.setContent("Una API REST es un estilo de arquitectura para construir servicios web.");
            post3.setCreationDate(LocalDateTime.parse("2025-07-14T10:10:00"));
            post3.setUser(exampleUser);

            Post post4 = new Post();
            post4.setTitle("Java en el Backend");
            post4.setContent("Java sigue siendo uno de los lenguajes más populares para el desarrollo de backend.");
            post4.setCreationDate(LocalDateTime.parse("2025-07-14T10:15:00"));
            post4.setUser(exampleUser);

            Post post5 = new Post();
            post5.setTitle("Proyecto de Portafolio");
            post5.setContent("Este blog es el primer proyecto de mi portafolio como desarrollador backend.");
            post5.setCreationDate(LocalDateTime.parse("2025-07-14T10:20:00"));
            post5.setUser(exampleUser);

           
            postRepository.saveAll(List.of(post1, post2, post3, post4, post5));

            System.out.println("Datos de ejemplo creados exitosamente.");
        }
    }
}