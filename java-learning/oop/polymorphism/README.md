```markdown
# Polymorphism in Java

Covers compile-time and runtime polymorphism through method overloading,
overriding, and a real-world payment processing example.

## Folders

| Folder | What it covers |
|--------|----------------|
| `method_overloading_compiletime` | Same method name, different params — resolved at compile time |
| `method_overriding_runtime` | Parent ref → child object — resolved at runtime by JVM |
| `method_overriding_and_overloading` | Both combined + upcasting/downcasting |
| `PaymentProcessBasics` | Polymorphism applied — basic payment flow |
| `PaymentProcessAdvanced` | Polymorphism applied — extended with real-world logic |

## Core idea

```java
Animal a = new Dog();  // runtime polymorphism
a.sound();             // JVM calls Dog's version, not Animal's
```
```
