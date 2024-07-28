# Sistema de Gestión de Usuarios

![UserManagementSystemImg](https://github.com/user-attachments/assets/5e80ef06-b026-42df-ab63-a1f9e5efe6ab)

## Descripción:

Este proyecto implementa una aplicación de gestion de usuarios utilizando el framework Spring Boot. Permite al administrador: crear, editar, eliminar y buscar usuarios, a través de una interfaz frontend sencilla.

## Tecnologías:

1. Java v21
2. SpringBoot v3.3.0
3.  MySQL
	### Dependencias:
	- Thymeleaf
	- Spring web
	- Spring Boot devTools
	- MySQL Driver
	- Spting Data JPA
	- Lombok

## Ejecución:

Clonar el repositorio del proyecto.
Instalar las dependencias necesarias (Maven).
Configurar las propiedades de conexión a bases de datos en "aplication properties".
Ejecutar la aplicación desde la línea de comandos: mvn spring-boot:run.
Acceder a la aplicación en la URL: `http://localhost:8080`.

## Funcionalidades:

Muestra todos los usuarios existentes en la base de datos
Creación de nuevo usuario
Borrar Usuario de usuario existente
Editar datos de Usuario Existente.
Buscar un Usuario a través de su ID único

## Próximos pasos:

Implementar un sistema de autenticación robusto (Spring Security - JWT).
