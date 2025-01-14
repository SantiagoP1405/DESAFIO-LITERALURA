# Challenge ONE Literalura - Santiago Patricio Gómez Ochoa

**Literalura** es un proyecto de gestión de autores y libros que utiliza tecnologías modernas para ofrecer una experiencia eficiente y fácil de usar. Permite consultar, almacenar y gestionar información sobre libros, autores y su disponibilidad en diferentes idiomas. Este proyecto está diseñado para interactuar tanto con una base de datos como con una API externa para obtener datos adicionales sobre libros.

## Tecnologías Implementadas

- **Java**: El lenguaje principal utilizado en el proyecto.
- **API Gutendex**: Se utiizaron datos de la API de libros [Gutendex].(https://gutendex.com/)
- **Spring Boot**: Framework para la creación de aplicaciones web y API RESTful.
- **Jakarta Persistence (JPA)**: Framework para la interacción con bases de datos y operaciones CRUD.
- **Hibernate**: Implementación de JPA que se utiliza para mapear las entidades a tablas en la base de datos.
- **Jackson**: Biblioteca para serializar y deserializar objetos Java a formato JSON y viceversa.
- **PostgreSQL**: Sistema de gestión de bases de datos utilizado para almacenar los datos de los libros y autores.

## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes:

- **com.santiagogomez.literalura.model**: Contiene las clases de modelo que representan los datos de la aplicación.
  - `Autor.java`: Representa un autor con atributos como nombre, fecha de nacimiento y defunción, y la lista de libros asociados.
  - `Libro.java`: Representa un libro con atributos como el título, los idiomas en los que está disponible y los autores asociados.
  
- **com.santiagogomez.literalura.repository**: Contiene los repositorios para interactuar con la base de datos.
  - `AutorRepository.java`: Repositorio de la entidad **Autor** para operaciones CRUD.
  - `LibroRepository.java`: Repositorio de la entidad **Libro** para operaciones CRUD y consultas avanzadas.

- **com.santiagogomez.literalura.service**: Contiene los servicios que gestionan la lógica de negocio.
  - `ConsumoAPI.java`: Servicio encargado de interactuar con APIs externas para obtener datos sobre libros.
  - `ConvierteDatos.java`: Servicio que convierte los datos de la API externa de JSON a objetos Java.

- **com.santiagogomez.literalura.principal**: Contiene la clase principal con el menú interactivo.
  - `Principal.java`: Clase que proporciona la interfaz de usuario en la terminal para interactuar con el sistema.

## Base de Datos
La base de datos se gestiona mediante Hibernate y JPA. La entidad Autor se almacena en una tabla llamada autores, 
mientras que los libros se almacenan en la tabla libros. Se utilizan anotaciones de JPA para mapear las clases a las tablas correspondientes.

## Funcionalidades
Consulta de catálogo completo: Visualiza los libros disponibles a través de paginación.
Búsqueda de libros por título: Permite buscar libros por su título y registrar nuevos libros en la base de datos.
Búsqueda de libros por autor: Muestra todos los libros asociados a un autor.
Búsqueda de libros por idioma: Permite buscar libros disponibles en un idioma específico.
Registro de libros y autores: Los usuarios pueden agregar nuevos libros y autores a la base de datos.
Interacción con APIs externas: Consumo de una API para obtener información adicional sobre los libros y autores.

## Uso del Proyecto
Ejecutar la aplicación: Al ejecutar la aplicación, puedes interactuar con un menú en la terminal que te permite buscar libros, agregar autores, y consultar el catálogo disponible.
Consultas a la base de datos: La aplicación maneja las consultas a la base de datos y las respuestas de la API externa, todo integrado de manera eficiente.
