# Sistema de Gestión de Suplementos (JPA & Hibernate)

Este proyecto es una aplicación de consola desarrollada en Java que implementa operaciones CRUD (Crear, Leer, Actualizar, Borrar) para un sistema de inventario de suplementos. El objetivo principal es demostrar el uso de **Mapeo Objeto-Relacional (ORM)** a través de **JPA** y **Hibernate**, conectándose a una base de datos **PostgreSQL**.

## Arquitectura y Patrones

El proyecto está estructurado utilizando el patrón **MVC (Modelo-Vista-Controlador)** adaptado para consola, separando claramente las responsabilidades (Single Responsibility Principle):

* **Model:** Entidades mapeadas a la base de datos mediante anotaciones JPA (`@Entity`, `@Table`, `@Id`, etc.).
* **View:** Interfaz de usuario basada en consola, encargada exclusivamente de la interacción con el usuario.
* **Controller:** Intermediario que procesa las peticiones de la vista y se comunica con la capa de acceso a datos.
* **DAO (Data Access Object):** Clases encargadas de encapsular la lógica de persistencia y las transacciones ACID utilizando el `EntityManager`.
* **Service (`JpaService`):** Implementación del patrón **Singleton** para garantizar una única instancia del `EntityManagerFactory` durante el ciclo de vida de la aplicación, optimizando el uso de recursos.

## Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Gestor de Dependencias:** Maven
* **Especificación ORM:** Jakarta Persistence API (JPA) 3.1
* **Implementación ORM:** Hibernate Core 6.4.4
* **Base de Datos:** PostgreSQL
* **IDE Recomendado:** IntelliJ IDEA

## Estructura del Proyecto

```text
src/main/java/ec/edu/ups/farmacia/
├── controller/
│   └── SuplementoController.java
├── dao/
│   └── SuplementoDAO.java
├── model/
│   └── Suplemento.java
├── service/
│   └── JpaService.java
├── view/
│   └── SuplementoView.java
│    
└── Main.java


src/main/resources/
└── META-INF/
    └── persistence.xml
```

## Configuración y Ejecución
### 1. Requisitos Previos:
Tener instalado Java JDK (21 o superior).

Tener instalado y en ejecución PostgreSQL.

Tener Maven instalado.

### 2. Base de Datos
Crear una base de datos vacía en PostgreSQL. Hibernate se encargará de generar las tablas automáticamente.

**Comando para crear la base de datos:**
```text
CREATE DATABASE farmacia_db;
```
Se incuye para propósito de pruebas el script `farmacia_db.sql` que se encuentra en la carpeta `src/main/resources`. Mediante el cual se puede revisar el contenido de la base de datos utilizada durante el desarrollo.

### 3. Configuración de Credenciales

Antes de ejecutar el proyecto, es necesario configurar las credenciales de conexión. Abrir el archivo src/main/resources/META-INF/persistence.xml y actualizar las siguientes propiedades con tu usuario y contraseña local:

```text
<property name="jakarta.persistence.jdbc.user" value="TU_USUARIO"/>
<property name="jakarta.persistence.jdbc.password" value="TU_CONTRASEÑA"/>
```

### 4. Ejecución del programa

El proyecto se compila y ejecuta utilizando Maven.

Para ejecutar el proyecto, compila las dependencias con Maven y ejecuta la clase principal Main.java desde tu IDE o consola.

También puedes ejecutar el archivo `farmacia.jar` que se encuentra en el directorio raiz del proyecto.

# Autor

### Jonathan Aguirre - Desarrollo inicial e implementación de persistencia
### Universidad Politécnica Salesiana
