# Student Grade Tracker

A Java CLI application for managing student records using **Object-Oriented Programming**, **HashMap**, and **PostgreSQL (JDBC)**. The project demonstrates CRUD operations, input validation, and academic performance analysis through a clean layered architecture.

---

## Features

* CRUD operations with PostgreSQL
* Fast student lookup using `HashMap`
* OOP with Inheritance, Polymorphism, Abstraction & Interfaces
* JDBC with Prepared Statements
* Input validation and exception handling
* Grade and percentage calculation
* Class average generation

---

## Tech Stack

* Java (JDK 17+)
* PostgreSQL
* JDBC
* HashMap
* OOP

---

## Project Structure

```text
Main.java
StudentManager.java
TeacherManager.java
GradeSystem.java
Student.java
Teacher.java
User.java
Authenticatable.java
```

---

## Architecture

```text
Authenticatable
        │
        ▼
   User (Abstract)
     /        \
Student       Teacher
      │          |
StudentManager  TeacherManager
      │               |
 PostgreSQL       PostgreSQL
```

---

## Learning Outcomes

* Object-Oriented Programming
* JDBC & PostgreSQL Integration
* CRUD Operations
* HashMap Optimization
* Input Validation
* Layered Architecture

---

## Author

Built as a Java backend learning project to demonstrate clean OOP design, JDBC database integration, and scalable student management principles.
