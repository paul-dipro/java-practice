# 📘 Student Grade Tracker (Java OOP CLI Project)


---


## 🧭 Problem Statement

Managing student records manually becomes inefficient when dealing with multiple students, marks calculation, and performance tracking. This CLI project simulates a lightweight student management system using Java to demonstrate **Object-Oriented Design, separation of concerns, and business logic structuring**.

---

## 🎯 Project Objective

To build a console-based system that:

* Stores student data
* Processes academic performance
* Calculates grades dynamically
* Generates reports and summaries

This project is designed as a foundation for backend development thinking in Java.

---

## 🛠️ Tech Stack

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- CLI (Command Line Interface)

## 🏗️ System Architecture

```
Main.java
   ↓ (User Interaction / Flow Control)
StudentManager.java
   ↓ (Business Logic / Operations)
Student.java
   ↓ (Data Model / Entity)
GradeSystem.java
   ↓ (Business Rules / Grading Logic)
```

---

## 📦 Modules Breakdown

### 1. Main (Entry Point)

* Handles program execution flow
* Displays menu
* Takes user input
* Calls StudentManager methods

---

### 2. StudentManager (Core Logic Layer)

Responsible for:

* Adding students
* Searching students
* Displaying reports
* Calculating averages
* Managing student collection (ArrayList)

---

### 3. Student (Data Model)

Represents a student entity with:

* Name
* Roll
* Marks
* Stream
* Percentage calculation

---

### 4. GradeSystem (Business Rule Engine)

Encapsulates grading logic:

* Converts marks into grades
* Keeps rule system separate from data handling

---

## 🧪 Features

* Add multiple students dynamically
* Validate user input
* Store student records in memory
* Calculate percentage automatically
* Assign grades based on marks
* Display full student report
* Compute class average
* Search student by roll number

---

## 📊 Grading System

| Marks Range | Grade |
| ----------- | ----- |
| 400 – 500   | A+    |
| 300 – 399   | A     |
| 225 – 299   | B     |
| 150 – 224   | C     |
| Below 150   | F     |

---

## ▶️ How to Run

### Compile

```bash
javac Main.java Student.java StudentManager.java GradeSystem.java
```

### Run

```bash
java Main
```

---

## 🧩 Sample Menu

```
_______________

     MENU
_______________

1. Add Students
2. Search Student
3. Display All
4. Average
5. Exit
```

---

## 📌 Example Output

```
Name       : DIPRO
Roll       : 12
Marks      : 445.0 / 500
Stream     : ARTS
Percentage : 89.00%
Grade      : A+
```
