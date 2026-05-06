# Abstract Methods & Abstract Classes

## What I Practiced
- Declaring an abstract class (`Animal`) with one abstract method and one concrete method
- Extending an abstract class (`Dog extends Animal`) and overriding the abstract method
- Upcasting: referencing a `Dog` object through an `Animal` reference

## Code Summary
```java
Animal a = new Dog(); // allowed — upcasting
// Animal a = new Animal(); // NOT allowed — abstract class
a.sound(); // runs Dog's version
a.eat();   // runs Animal's concrete method
```

