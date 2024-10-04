# Palace of Fantasy Movie API

The Palace of Fantasy Movie API is a Spring Boot application that provides RESTful APIs for managing movies, actors, directors, and genres. It allows users to perform CRUD operations on these entities and retrieve information about movies and their associated actors, directors, and genres.

## Features

- Create, read, update, and delete movies, actors, directors, and genres
- Establish relationships between movies and their associated actors, directors, and genres
- Validate input data using Jakarta Bean Validation
- Implement error handling for resource not found scenarios
- Secure the API endpoints using Spring Security
- Generate API documentation using Swagger
- Initialize sample data using a `DataInitializer` class

## Technologies Used

- Java 17
- Spring Boot 3.1.12
- Spring Data JPA
- Spring Security
- Hibernate
- MapStruct
- Lombok
- Swagger (OpenAPI)
- H2 Database (for testing)
- MariaDB (for production)
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- MariaDB (or any other relational database)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/palace-of-fantasy-movie-api.git
