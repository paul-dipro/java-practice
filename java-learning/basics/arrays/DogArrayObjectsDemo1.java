class Dog {
    int age;

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    boolean isOld() {
        return age > 5;
    }
}

public class DogArrayObjectsDemo1 {
    public static void main(String[] args) {

        Dog[] dogs = new Dog[4];

        dogs[0] = new Dog();
        dogs[0].setAge(3);

        dogs[2] = new Dog();
        dogs[2].setAge(8);

        for (int i = 0; i < dogs.length; i++) {

            if (dogs[i] != null) {
                System.out.println("Index " + i + ": Age = " +
                        dogs[i].getAge() + ", Old = " + dogs[i].isOld());
            } else {
                System.out.println("Index " + i + ": No Dog");
            }
        }
    }
}