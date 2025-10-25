A simple Full Stack CRUD (Create, Read, Update, Delete) application built with Spring Boot, React, and H2 Database.
 This project allows users to manage student details like name, age, and email.
 
 # Technologies Used
 Backend:
 Java 17+
 Spring Boot
 Spring Data JPA
 H2 Database (in-memory)
 Maven
 Frontend:
 React.js
 Axios (for API calls)
 HTML / CSS / JavaScript
 
 # Features
 ✅ Add new student
 ✅ View all students
 ✅ Update student details
 ✅ Delete student
 ✅ Integrated frontend and backend
 ✅ In-memory database (H2)
 
 # Project Structure:
student-management/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── student/
│   │                       ├── controller/
│   │                       │   └── StudentController.java
│   │                       ├── service/
│   │                       │   └── StudentService.java
│   │                       ├── repository/
│   │                       │   └── StudentRepository.java
│   │                       └── model/
│   │                           └── Student.java
│   └── resources/
│       └── application.properties
│
└── frontend/
    ├── src/
    │   ├── components/
    │   │   ├── AddStudent.js
    │   │   ├── StudentList.js
    │   │   ├── UpdateStudent.js
    │   │   └── DeleteStudent.js
    │   ├── App.js
    │   └── index.js

 # API Endpoints (Spring Boot)
 | Method | Endpoint         | Description            |
 | ------ | ---------------- | ---------------------- |
 | POST   | /students      | Create a new student   |
 | GET    | /students      | Get all students       |
 | PUT    | /students/{id} | Update a student by ID |
 | DELETE | /students/{id} | Delete a student by ID |
