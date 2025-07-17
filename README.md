# Blog API con Spring Boot y JWT

API RESTful para un blog simple, construida con Java y Spring Boot. Incluye un sistema completo de autenticación y autorización de usuarios basado en JSON Web Tokens (JWT).

## Tecnologías Utilizadas
* **Java 17**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **MySQL**
* **JSON Web Tokens (JWT)**
* **Lombok**
* **Maven**

## Features
* **CRUD completo** para los artículos del blog (Posts).
* **Registro de usuarios** con contraseñas cifradas (BCrypt).
* **Autenticación de usuarios** que genera un token JWT.
* **Rutas protegidas:** Solo los usuarios autenticados pueden crear, modificar o eliminar posts.

## Cómo Ejecutar Localmente
1.  Clonar el repositorio: `git clone <tu-url-de-github>`
2.  Crear una base de datos en MySQL llamada `blog_api`.
3.  Actualizar el archivo `src/main/resources/application.properties` con tus credenciales de MySQL:
    ```properties
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```
4.  Ejecutar el proyecto desde tu IDE o usando Maven: `mvn spring-boot:run`

## Endpoints de la API

### Autenticación
* **`POST /api/auth/register`**: Registra un nuevo usuario.
    ```json
    {
        "username": "nuevo_usuario",
        "password": "password123"
    }
    ```
* **`POST /api/auth/login`**: Autentica un usuario y devuelve un token JWT.
    ```json
    {
        "username": "nuevo_usuario",
        "password": "password123"
    }
    ```

### Posts (Rutas Protegidas)
Para acceder a estas rutas, debes incluir el token en la cabecera de la petición:
`Authorization: Bearer <tu_token_jwt>`

* **`GET /api/posts`**: Obtiene todos los posts.
* **`POST /api/posts`**: Crea un nuevo post.
* **`GET /api/posts/{id}`**: Obtiene un post por su ID.
* **`PUT /api/posts/{id}`**: Actualiza un post existente.
* **`DELETE /api/posts/{id}`**: Elimina un post.