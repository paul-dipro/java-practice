class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void displayStudent() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }

    boolean hasPassed() {
        return marks >= 40;
    }
}

public class StudentReportDemo {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student("Dipto", 78);
        students[1] = new Student("Priya", 35);
        students[2] = new Student("Ratul", 90);
        students[3] = new Student("Sneha", 42);
       

        int totalMarks = 0;
        int totalStudents = 0;
        int passedCount = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.print("Index " + i + " -> ");
                students[i].displayStudent();

                totalMarks += students[i].marks;
                totalStudents++;

                if (students[i].hasPassed()) {
                    passedCount++;
                }
            } else {
                System.out.println("Index " + i + " -> No student object");
            }
        }

        if (totalStudents > 0) {
            double average = (double) totalMarks / totalStudents;

            System.out.println("\nTotal Students Created: " + totalStudents);
            System.out.println("Passed Students: " + passedCount);
            System.out.println("Average Marks: " + average);
        } else {
            System.out.println("No students available.");
        }
    }
}