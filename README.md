# API de Blog con Spring Boot

Este es el backend para una aplicación de blog, desarrollado con Java y Spring Boot. La API gestiona usuarios y posts, y está asegurada con Spring Security y JWT. El proyecto se inicializa con datos de ejemplo para facilitar la demostración.

### 🚀 Demo en Vivo

La API está desplegada y completamente funcional en Render. Puedes probar los endpoints públicos directamente.

**URL Base:** `https://blog-api-9yxz.onrender.com`

---

### 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3
* **Seguridad:** Spring Security (Autenticación con JWT)
* **Base de Datos:** Spring Data JPA (Hibernate) con PostgreSQL
* **Contenerización:** Docker
* **Despliegue:** Render y Neon (para la base de datos permanente)

---

### ✨ Features

* **Gestión de Posts (CRUD):** Endpoints para crear, leer, actualizar y eliminar posts.
* **Autenticación de Usuarios:** Registro y Login para usuarios.
* **Autorización:** Rutas protegidas que requieren un token JWT válido.
* **Inicialización de Datos:** La aplicación se inicia con un usuario y varios posts de ejemplo para una demostración inmediata.
* **Despliegue Profesional:** La aplicación está contenerizada con Docker y desplegada en la nube, demostrando un ciclo de vida de desarrollo completo.

---

### ⚙️ Endpoints de la API

#### Autenticación (`/api/auth`)

* `POST /register`: Registra un nuevo usuario.
* `POST /login`: Autentica un usuario y devuelve un token JWT.

#### Posts (`/api/posts`)

* `GET /`: Obtiene todos los posts (Público).
* `GET /{id}`: Obtiene un post por su ID (Público).
* `POST /`: Crea un nuevo post (Requiere token de autenticación).
* `PUT /{id}`: Actualiza un post existente (Requiere token de autenticación).
* `DELETE /{id}`: Elimina un post (Requiere token de autenticación).

---
**Nota sobre el Despliegue Gratuito:**
Esta API está desplegada en el plan gratuito de Render. Si es la primera vez que la usas después de un tiempo, la primera petición puede tardar hasta un minuto en responder mientras el servidor se "despierta". ¡Ten paciencia! Las peticiones siguientes serán instantáneas.
---