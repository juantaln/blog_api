package com.portafolio.blog_api.services;

// --- Importa las nuevas clases DTO ---
import com.portafolio.blog_api.dto.PostRequestDto;
import com.portafolio.blog_api.dto.PostResponseDto;

import com.portafolio.blog_api.entities.Post;
import com.portafolio.blog_api.entities.User;
import com.portafolio.blog_api.repositories.PostRepository;
import com.portafolio.blog_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * ✅ CREAR: Recibe un DTO, busca el usuario y guarda una nueva entidad Post.
     * Devuelve el post creado como un DTO de respuesta.
     */
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        // 1. Busca el usuario por el ID proporcionado en el DTO
        User user = userRepository.findById(postRequestDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + postRequestDto.getUserId()));

        // 2. Crea la nueva entidad Post a partir de los datos del DTO
        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setUser(user); // Asigna la entidad User completa

        // 3. Guarda la entidad en la base de datos
        Post newPost = postRepository.save(post);

        // 4. Convierte la entidad guardada a un DTO de respuesta para devolverla
        return mapToResponseDto(newPost);
    }

    /**
     * ✅ OBTENER TODOS: Busca todos los posts y los convierte en una lista de DTOs.
     */
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToResponseDto) // Usa el método de conversión
                .collect(Collectors.toList());
    }

    /**
     * ✅ OBTENER POR ID: Busca un post y, si lo encuentra, lo convierte en un DTO.
     */
    public Optional<PostResponseDto> getPostById(Long id) {
        return postRepository.findById(id)
                .map(this::mapToResponseDto); // Convierte a DTO si existe
    }

    /**
     * ✅ ACTUALIZAR: Recibe un DTO, busca el post existente y actualiza sus campos.
     */
    public Optional<PostResponseDto> updatePost(Long id, PostRequestDto postRequestDto) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    existingPost.setTitle(postRequestDto.getTitle());
                    existingPost.setContent(postRequestDto.getContent());
                    // Nota: No cambiamos el autor en una actualización
                    Post updatedPost = postRepository.save(existingPost);
                    return mapToResponseDto(updatedPost);
                });
    }

    /**
     * ✅ BORRAR: La lógica no cambia, ya que no maneja DTOs.
     */
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- MÉTODO PRIVADO DE UTILIDAD ---
    /**
     * Convierte una entidad Post en un PostResponseDto.
     * Esto centraliza la lógica y evita repetir código.
     */
    private PostResponseDto mapToResponseDto(Post post) {
        PostResponseDto dto = new PostResponseDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCreationDate(post.getCreationDate());
        
        // Importante: Asigna el nombre de usuario para evitar exponer el objeto User completo
        if (post.getUser() != null) {
            dto.setAuthorUsername(post.getUser().getUsername());
        }
        
        return dto;
    }
}