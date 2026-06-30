# 🎓 Student Grade Tracker

A production-style Java CLI application that demonstrates modern Object-Oriented Programming principles, efficient data management, role-based architecture, and persistent student record storage.

---

## 📖 Overview

Managing student records manually becomes increasingly difficult as data volume grows. Traditional sequential searches become inefficient, and maintaining data consistency across sessions requires reliable persistence.

**Student Grade Tracker** solves these challenges through a scalable, object-oriented architecture that combines:

* Fast student lookups using `HashMap`
* Polymorphic role management
* File-based persistence
* Academic performance analytics
* Strong input validation

The project is designed as a practical demonstration of enterprise-style Java backend design while remaining simple enough to run from the command line.

---

# 🎯 Key Features

## ⚡ O(1) Student Lookup

Instead of relying on sequential searches through collections, the system stores users in a:

```java
HashMap<Integer, User>
```

This provides near-constant-time retrieval, updates, and deletions.

---

## 🏗️ Polymorphic User Architecture

The application follows a role-based hierarchy:

```text
Authenticatable (Interface)
          │
          ▼
      User (Abstract)
       /       \
      ▼         ▼
 Student     Teacher
```

This structure enables clean extensibility while promoting code reuse.

---

## 🔒 Data Integrity & Validation

The system protects against invalid input through:

* Unique roll number enforcement
* Marks range validation (0–500)
* Empty field prevention
* Numeric input checking using `InputMismatchException`
* Scanner buffer handling to avoid input corruption

---

## 💾 Persistent Storage

Student records are automatically saved to a local text file using CSV serialization.

### Example Storage Format

```text
12,DIPRO PAUL,dipropaul@email.com,445.0,2
45,TUG,oisghoig@email.com,376.0,1
```

Data is loaded automatically when the application starts and saved when exiting.

---

## 📊 Academic Analytics

The grading engine calculates:

* Percentage scores
* Letter grades
* Student performance reports
* Class averages

---

# 🛠️ Tech Stack

| Component      | Technology                                           |
| -------------- | ---------------------------------------------------- |
| Language       | Java (JDK 17+)                                       |
| Architecture   | Object-Oriented Programming                          |
| Concepts       | Inheritance, Polymorphism, Encapsulation, Interfaces |
| Data Structure | HashMap                                              |
| Persistence    | BufferedReader, BufferedWriter                       |
| Interface      | Command Line Interface (CLI)                         |

---

# 🏛️ System Architecture

```text
        ┌─────────────────────┐
        │  Authenticatable    │
        │     Interface       │
        └──────────┬──────────┘
                   │
                   ▼
        ┌─────────────────────┐
        │    User (Abstract)  │
        └───────┬─────┬───────┘
                │     │
                ▼     ▼
         Student    Teacher
                │
                ▼
              Main
                │
                ▼
        StudentManager
                │
                ▼
          GradeSystem
```

---

# 📦 Project Structure

```text
.
├── Main.java
├── User.java
├── Student.java
├── Teacher.java
├── Authenticatable.java
├── StudentManager.java
├── GradeSystem.java
└── students.txt
```

---

# 📚 Module Breakdown

## Main.java

Acts as the application entry point.

### Responsibilities

* Starts the program
* Loads stored student records
* Displays the CLI menu
* Routes user actions to business logic

---

## StudentManager.java

Core business logic and registry layer.

### Responsibilities

* Add students
* Search students
* Update records
* Delete records
* Display all students
* Save and load data
* Input validation

### Internal Storage

```java
HashMap<Integer, User>
```

---

## User.java

Abstract base class representing common user attributes.

### Properties

```java
userId
name
email
```

Provides encapsulation through getters and setters.

---

## Student.java

Represents student-specific entities.

### Responsibilities

* Store academic records
* Display student dashboard
* Participate in grade calculations

---

## Teacher.java

Represents administrative users.

### Responsibilities

* Custom dashboard rendering
* Teacher-specific functionality

---

## Authenticatable.java

Interface contract enforcing authentication behavior.

```java
boolean login(...)
```

---

## GradeSystem.java

Dedicated rules engine responsible for academic evaluation.

### Responsibilities

* Grade assignment
* Percentage calculation
* Academic performance classification

---

# 📊 Grading Matrix

| Marks     | Grade |
| --------- | ----- |
| 400 – 500 | A+    |
| 300 – 399 | A     |
| 225 – 299 | B     |
| 150 – 224 | C     |
| Below 150 | F     |

---

# ▶️ Running the Project

## Compile

```bash
javac Main.java User.java Student.java Teacher.java StudentManager.java GradeSystem.java Authenticatable.java
```

## Run

```bash
java Main
```

---

# 🧩 Sample CLI Menu

```text
_______________

       MENU
_______________

1. Add Students
2. Search Student
3. Display All
4. Average
5. Update Data
6. Delete Data
7. Save / Exit

Choose an option:
```

---

# 🚀 Learning Outcomes

This project demonstrates practical implementation of:

* Object-Oriented Design
* Inheritance
* Polymorphism
* Abstraction
* Interfaces
* Encapsulation
* HashMap-based optimization
* File I/O persistence
* Input validation
* Layered application architecture

---

# 🔮 Future Enhancements

* Password-based authentication
* Role-based authorization
* Database integration (MySQL/PostgreSQL)
* JavaFX GUI
* REST API layer
* Student ranking system
* Export to CSV/PDF reports
* Unit testing with JUnit

---

## 👨‍💻 Author

Built as a Java OOP learning project focused on clean architecture, performance optimization, and maintainable software design.
