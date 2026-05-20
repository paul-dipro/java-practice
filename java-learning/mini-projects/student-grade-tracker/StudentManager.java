import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    public void collectStudents() {
        int n = getValidStudentCount();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            String name       = getValidName();
            double marks      = getValidMarks();
            int[]  streamData = getValidStream();
            String streamName = resolveStreamName(streamData[0]);

            students.add(new Student(name, marks, streamData[0], streamName));
        }
    }


    public void displayAllStudents() {
        System.out.println("\n========== STUDENT REPORT ==========");
        for (Student s : students) {
            System.out.printf("""
                    
                    Name       : %s
                    Marks      : %.1f / 500
                    Stream     : %s
                    Percentage : %.1f%%
                    """,
                    s.getStudentName(),
                    s.getStudentMarks(),
                    s.getStreamName(),
                    s.getPercentage()
            );
        }
    }


    public void displayAverage() {
        double total = 0;
        for (Student s : students) {
            total += s.getStudentMarks();
        }
        double average = total / students.size();
        System.out.printf("%n========== CLASS AVERAGE ==========\nAverage Marks: %.2f / 500%n", average);
    }


    private int getValidStudentCount() {
        int n;
        while (true) {
            System.out.print("Enter number of students (must be more than 10): ");
            n = sc.nextInt();
            if (n > 10) break;
            System.out.println("Not enough students! Must be more than 10.");
        }
        return n;
    }

    private String getValidName() {
        System.out.print("Enter student's name: ");
        return sc.nextLine().toUpperCase().trim();
    }

    private double getValidMarks() {
        double marks;
        while (true) {
            System.out.print("Enter student's marks (0 - 500): ");
            marks = sc.nextDouble();
            sc.nextLine();
            if (marks >= 0 && marks <= 500) break;
            System.out.println("Invalid! Marks must be between 0 and 500.");
        }
        return marks;
    }

    private int[] getValidStream() {
        int streamCode;
        while (true) {
            System.out.print("Select stream:\n  1. Science\n  2. Arts\n  3. Commerce\nChoice: ");
            streamCode = sc.nextInt();
            sc.nextLine();
            if (streamCode >= 1 && streamCode <= 3) break;
            System.out.println("Invalid! Choose 1, 2, or 3.");
        }
        return new int[]{streamCode};
    }

    private String resolveStreamName(int code) {
        return switch (code) {
            case 1 -> "SCIENCE";
            case 2 -> "ARTS";
            case 3 -> "COMMERCE";
            default -> "UNKNOWN";
        };
    }
}