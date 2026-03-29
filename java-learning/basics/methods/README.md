# Methods in Java

## 📌 Core Idea

A method is a block of code that performs a task and can be reused.

---

## 🔹 Syntax

```java
returnType methodName(parameters) {
    // body
}
```

---

## 🔹 Example

```java
class Main {
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(2, 3);
        System.out.println(result);
    }
}
```

---

## ⚔️ Types

* **Void method** → no return value
* **Return method** → returns value

---

## ⚠️ Rules

* Method must be called to execute
* Return type must match returned value
* Static methods don’t need object

---

## 🎯 Key Insight

* Methods = code reuse + cleaner structure
* Break problems into small methods
