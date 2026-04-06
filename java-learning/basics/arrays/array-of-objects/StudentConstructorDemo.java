import java.util.Scanner;

class Student {
    int marks;
    String result;

    Student(int marks) {
        this.marks = marks;

        if (marks >= 40) {
            result = "Pass";
        } else {
            result = "Fail";
        }
    }

    int getMarks() {
        return marks;
    }

    String getResult() {
        return result;
    }

    boolean isPass() {
        return marks >= 40;
    }
}

public class StudentConstructorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        int countPass = 0;
        int countFail = 0;

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            int m = sc.nextInt();

            students[i] = new Student(m);

            if (students[i].isPass()) {
                countPass++;
            } else {
                countFail++;
            }
        }

        for (int j = 0; j < students.length; j++) {
            System.out.println(
                "Student " + (j + 1) +
                " | Marks: " + students[j].getMarks() +
                " | Status: " + students[j].getResult()
            );
        }

        System.out.println("\n--- Final Statistics ---");
        System.out.println("Total students passed: " + countPass);
        System.out.println("Total students failed: " + countFail);

        sc.close();
    }
}