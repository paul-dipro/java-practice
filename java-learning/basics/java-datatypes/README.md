# Java Data Types

## Overview

Data types in Java define the type of data a variable can hold. They are broadly classified into **primitive** and **non-primitive (reference)** types.

---

## Primitive Data Types

| Type    | Example       | Description      |
| ------- | ------------- | ---------------- |
| int     | `int a = 10;` | Integer values   |
| double  | `5.5`         | Decimal values   |
| boolean | `true`        | True/false       |
| char    | `'A'`         | Single character |

---

## Non-Primitive Data Types

* String → `"Hello"`
* Arrays → `int[] arr = {1,2,3};`
* Classes, Objects

---

## Key Concepts

### 1. Type Casting

**Implicit (Widening)**

```java
int a = 10;
double b = a;
```

**Explicit (Narrowing)**

```java
double a = 10.9;
int b = (int) a; // 10
```

---

### 2. Integer Overflow

```java
int x = 2147483647;
x = x + 1; // becomes negative
```

---

### 3. Floating Point Precision

```java
System.out.println(0.1 + 0.2); // not exactly 0.3
```

---

### 4. String Comparison

```java
String a = "hello";
String b = "hello";

System.out.println(a == b);        // reference check
System.out.println(a.equals(b));   // value check
```

---

## Notes

* Use `int` for integers, `double` for decimals.
* Avoid unnecessary types (`byte`, `short`, `float`) unless needed.
* Be careful with casting and precision issues.

