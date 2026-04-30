package method_abstract;

abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

}

public class AbstractTest {
    public static void main(String[] args) {
        // Animal a = new Animal(); never use this here it's not allowed to use here

        Animal a = new Dog(); // it's allowed

        a.sound(); // Dog method
        a.eat();   // Animal method
    }
}