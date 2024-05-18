import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private final GradeSystem gradeSystem = new GradeSystem();

    // =========================
    // COLLECT STUDENT DATA
    // =========================
    public void collectStudents() {

        int totalStudents = getValidStudentCount();

        for (int i = 0; i < totalStudents; i++) {

            System.out.println("\n========== STUDENT " + (i + 1) + " ==========");

            String name = getValidName();
            double marks = getValidMarks();

            int streamCode = getValidStream();
            String streamName = resolveStreamName(streamCode);

            students.add(
                    new Student(name, marks, streamCode, streamName)
            );
        }
    }

    // =========================
    // DISPLAY ALL STUDENTS
    // =========================
    public void displayAllStudents() {

        System.out.println("\n========== STUDENT REPORT ==========");

        for (Student s : students) {

            String grade = gradeSystem.getGrade(s.getMarks());

            System.out.printf("""
                        
                        Name       : %s
                        Marks      : %.1f / 500
                        Stream     : %s
                        Percentage : %.2f%%
                        Grade      : %s
                        """,
                    s.getName(),
                    s.getMarks(),
                    s.getStreamName(),
                    s.getPercentage(),
                    grade
            );
        }
    }

    // =========================
    // DISPLAY CLASS AVERAGE
    // =========================
    public void displayAverage() {

        double totalMarks = 0;

        for (Student s : students) {
            totalMarks += s.getMarks();
        }

        double average = totalMarks / students.size();

        System.out.printf("""
                    
                    ========== SCHOOL AVERAGE ==========
                    Average Marks : %.2f / 500
                    """,
                average
        );
    }

    // =========================
    // VALIDATIONS
    // =========================

    private int getValidStudentCount() {

        int count;

        while (true) {

            System.out.print("Enter number of students: ");

            count = sc.nextInt();
            sc.nextLine();

            if (count > 0) {
                return count;
            }

            System.out.println("Invalid! Student count must be greater than 0.");
        }
    }

    private String getValidName() {

        while (true) {

            System.out.print("\nEnter student name: ");

            String name = sc.nextLine().trim();

            if (!name.isEmpty()) {
                return name.toUpperCase();
            }

            System.out.println("Name cannot be empty.");
        }
    }

    private double getValidMarks() {

        double marks;

        while (true) {

            System.out.print("Enter marks (0 - 500): ");

            marks = sc.nextDouble();
            sc.nextLine();

            if (marks >= 0 && marks <= 500) {
                return marks;
            }

            System.out.println("Invalid! Marks must be between 0 and 500.");
        }
    }

    private int getValidStream() {

        int streamCode;

        while (true) {

            System.out.println("""
                    
                    Select Stream
                    1. Science
                    2. Arts
                    3. Commerce
                    """);

            System.out.print("Choice: ");

            streamCode = sc.nextInt();
            sc.nextLine();

            if (streamCode >= 1 && streamCode <= 3) {
                return streamCode;
            }

            System.out.println("Invalid! Choose between 1 - 3.");
        }
    }

    // =========================
    // STREAM RESOLUTION
    // =========================
    private String resolveStreamName(int code) {

        return switch (code) {

            case 1 -> "SCIENCE";
            case 2 -> "ARTS";
            case 3 -> "COMMERCE";

            default -> "UNKNOWN";
        };
    }
}