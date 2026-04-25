class Student {
    int age;

    void setAge(int a) {
        age = a;
    }

    int getAge() {
        return age;
    }
}

public class StudentsArrayCountDemo {
    public static void main(String[] args) {

        Student[] students = new Student[5];

        for (int i = 0; i < students.length; i++) {
            if (i != 2) {
                students[i] = new Student();
                students[i].setAge(i + 2);
            }
        }

        int count = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println("Index " + i + ": " + students[i].getAge());
                count++;

                if (students[i].getAge() > 4) {
                    System.out.println("Age greater than 4 at index " + i);
                }
            } else {
                System.out.println("Index " + i + ": null");
            }
        }

        System.out.println("Total students created = " + count);
    }
}