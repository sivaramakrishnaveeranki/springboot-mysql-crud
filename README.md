# springboot-mysql-crud
A Spring Boot CRUD REST API application built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL. It demonstrates Create, Read, Update, and Delete (CRUD) operations with a layered architecture.
# Spring Boot CRUD API

A RESTful CRUD application built with Spring Boot and MySQL that demonstrates Create, Read, Update, and Delete (CRUD) operations using Spring Data JPA and Hibernate.

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman (API Testing)

## 📌 Features

- Create Student
- Get All Students
- Get Student By ID
- Update Student
- Delete Student
- MySQL Database Integration
- RESTful APIs
- Layered Architecture

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   └── SpringBootCrudApplication.java
│   └── resources
│       └── application.properties
```

## 🛠️ API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /students | Create Student |
| GET | /students | Get All Students |
| GET | /students/{id} | Get Student By ID |
| PUT | /students/{id} | Update Student |
| DELETE | /students/{id} | Delete Student |

## ⚙️ Setup

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Create the database
4. Run the Spring Boot application
5. Test the APIs using Postman

## 👨‍💻 Author

**Siva Rama Krishna Veeranki**
