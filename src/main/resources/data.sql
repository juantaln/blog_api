-- Primero, crea un usuario de ejemplo para que los posts tengan un autor
INSERT INTO users (username, password) VALUES ('autor_ejemplo', 'password123');

-- Ahora, inserta los posts y asígnalos al usuario que acabamos de crear (user_id = 1)
INSERT INTO posts (title, content, creation_date, user_id) VALUES
('Bienvenida al Blog', 'Este es el primer post, generado automáticamente.', '2025-07-14 10:00:00', 1),
('¿Qué es Spring Boot?', 'Spring Boot es un framework que facilita la creación de aplicaciones Java.', '2025-07-14 10:05:00', 1),
('Sobre las API REST', 'Una API REST es un estilo de arquitectura para construir servicios web.', '2025-07-14 10:10:00', 1),
('Java en el Backend', 'Java sigue siendo uno de los lenguajes más populares para el desarrollo de backend.', '2025-07-14 10:15:00', 1),
('Proyecto de Portafolio', 'Este blog es el primer proyecto de mi portafolio como desarrollador backend.', '2025-07-14 10:20:00', 1);