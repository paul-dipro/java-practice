class Student {
    int age;

    void setAge(int a) {
        age = a;
    }

    int getAge() {
        return age;
    }
}

public class StudentStatsDemo {
    public static void main(String[] args) {

        Student[] students = new Student[6];

        for (int i = 0; i < students.length; i++) {
            if (i != 1 && i != 4) {
                students[i] = new Student();
                students[i].setAge(i + 3);
            }
        }

        int count = 0;
        int sum = 0;
        int maxAge = Integer.MIN_VALUE;
        int evenCount = 0;
        double avg;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                int age = students[i].getAge();

                System.out.println("Index " + i + ": " + age);

                count++;
                sum += age;

                if (age > maxAge) {
                    maxAge = age;
                }

                if (age % 2 == 0) {
                    evenCount++;
                }

            } else {
                System.out.println("Index " + i + ": null");
            }
        }

        if (count > 0) {
            avg = (double) sum / count;
        } else {
            avg = 0;
        }

        System.out.println("Total students = " + count);
        System.out.println("Max age = " + maxAge);
        System.out.println("Average age = " + avg);
        System.out.println("Even age count = " + evenCount);
    }
}
