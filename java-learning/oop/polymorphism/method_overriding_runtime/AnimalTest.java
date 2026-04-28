package method_overriding_runtime;


class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();
    }
}