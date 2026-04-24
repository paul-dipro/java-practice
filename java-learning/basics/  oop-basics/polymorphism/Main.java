public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Tiger tiger = new Tiger();

        Animal[] animals = {dog, cat, tiger};

        for (Animal animal : animals) {
            System.out.print(animal.getClass().getSimpleName() + ": ");
            animal.favFood();
        }
    }
}