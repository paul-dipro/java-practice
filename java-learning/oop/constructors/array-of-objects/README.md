# Array of Objects (Java)

This folder shows how arrays work when they store objects instead of simple values.

## What I learned

* Creating an array like `new Student[5]` does NOT create objects
* All indexes are `null` initially
* I must create each object using `new Student()`
* If I use an index without creating an object → NullPointerException
* Arrays store references, not actual objects

## What I practiced

* Creating objects only at specific indexes (even indexes)
* Checking `!= null` before accessing data
* Using getter and setter instead of direct variable access

## Files

* `StudentArrayEvenIndexDemo.java` → basic version
* `StudentArrayWithGetterSetterDemo.java` → improved OOP version

## Key takeaway

Array of objects = array + manually created objects

If I skip object creation → program crashes
