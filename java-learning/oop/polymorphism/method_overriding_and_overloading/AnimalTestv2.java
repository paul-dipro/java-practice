package method_overriding_and_overloading;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }

    void eat(int food) {
        System.out.println("Animal eats " + food);
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    //overloading
    void eat(int food, int times) {
        System.out.println("Dog eats " + food + " for " + times + " times");
    }
}

public class AnimalTestv2 {
    public static void main(String[] args) {


        Animal a = new Dog(); // upcasting


        a.sound();
        a.eat(5);


        Dog d = new Dog();
        d.eat(5, 2);

        ((Dog) a).eat(8, 5); // downcasting to access overloaded method
    }
}