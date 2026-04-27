class Dog {
    String name;
    int age;
    Dog(String name, int age){ this.name = name; this.age = age; }
    void celebrateBirthday(){ age++; }
    void show(){ System.out.println(name + " " + age); }
}

public class DogDemo {
    public static void main(String[] args){
        Dog d1 = new Dog("Fido", 2);
        Dog d2 = new Dog("Rex", 3);
        d1.celebrateBirthday();  // Fido becomes 3
        d1.show(); // expect: Fido 3
        d2.show(); // expect: Rex 3
    }
}