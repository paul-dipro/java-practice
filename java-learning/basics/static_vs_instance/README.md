# Static vs Instance in Java

## 📌 Core Idea

* **Instance** → belongs to object (separate copy per object)
* **Static** → belongs to class (single shared copy)

---

## 🔹 Example

```java
class Student {
    String name;          // instance
    static String school; // static
}
```

---

## ⚔️ Difference

| Static      | Instance     |
| ----------- | ------------ |
| Class-level | Object-level |
| Shared      | Unique       |
| No object   | Needs object |

---

## ⚠️ Rule

Static methods **cannot directly access instance variables**

---

## 🎯 Key Insight

* Use `static` for shared data
* Use `instance` for object-specific data

