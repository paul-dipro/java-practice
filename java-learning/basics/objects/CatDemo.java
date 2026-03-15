class Cat {
    int age = 2;
    void grow() { age = age + 1; }
    void printAge() { System.out.println(age); }
}

public class CatDemo {
    public static void main(String[] args) {
        Cat a = new Cat();
        Cat b = a;
        a.grow();
        b.grow();
        a.printAge();   // expect 4
        b.printAge();   // expect 4
    }
}