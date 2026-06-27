import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class StudentManager {

    // 1. ALL FIELDS AT THE TOP
    private final Scanner sc = new Scanner(System.in);
    private final GradeSystem gradeSystem = new GradeSystem();
    private final String FILE_NAME = "students.txt";
    private HashMap<Integer, Student> studentsMap = new HashMap<>();

    // =========================
    // COLLECT STUDENT DATA
    // =========================
    public void collectStudents() {
        int totalStudents = getValidStudentCount();

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\n========== STUDENT " + (i + 1) + " ==========");
            String name = getValidName();
            int roll    = getValidRoll();
            double marks = getValidMarks();

            int streamCode = getValidStream();
            String streamName = resolveStreamName(streamCode);

            Student newStudent = new Student(name, roll, marks, streamCode, streamName);
            studentsMap.put(roll, newStudent);
        }
    }

    // =========================
    // DISPLAY ALL STUDENTS
    // =========================
    public void displayAllStudents() {
        if (studentsMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT REPORT ==========");
        for (Student s : studentsMap.values()) {
            String grade = gradeSystem.getGrade(s.getMarks());

            System.out.printf("""
                        
                        Name       : %s
                        Roll       : %d
                        Marks      : %.1f / 500
                        Stream     : %s
                        Percentage : %.2f%%
                        Grade      : %s
                        """,
                    s.getName(),
                    s.getRoll(),
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
        // FIXED: Using studentsMap instead of deleted 'students' list
        if (studentsMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalMarks = 0;
        for (Student s : studentsMap.values()) {
            totalMarks += s.getMarks();
        }

        double average = totalMarks / studentsMap.size();

        System.out.printf("""
        ========= SCHOOL AVERAGE =========
        Average Marks : %.2f / 500
        """, average);
    }

    // =========================
    // VALIDATIONS
    // =========================
    private int getValidStudentCount() {
        int count;
        while (true) {
            System.out.print("Enter number of students: ");
            try {
                count = sc.nextInt();
                sc.nextLine();
                if (count > 0) {
                    return count;
                }
                System.out.println("Invalid! Student count must be greater than 0.");
            } catch (InputMismatchException e) {
                System.out.println("Numbers only.");
                sc.nextLine();
            }
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

    private int getValidRoll() {
        while (true) {
            System.out.print("Roll: ");
            try {
                int roll = sc.nextInt();
                sc.nextLine();

                // FIXED & OPTIMIZED: Replaced the old slow loop with an instant containsKey search!
                boolean isDuplicate = studentsMap.containsKey(roll);

                if (roll > 0 && !isDuplicate) {
                    return roll;
                }
                System.out.println("Roll must be positive and unique.");
            } catch (InputMismatchException e) {
                System.out.println("Numbers only.");
                sc.nextLine();
            }
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

    // =========================
    // SEARCH STUDENT
    // =========================
    public void searchByRoll(int roll) {
        // OPTIMIZED: Utilizing our O(1) find method directly instead of looping!
        Student s = findStudentByRoll(roll);

        if (s != null) {
            String grade = gradeSystem.getGrade(s.getMarks());
            System.out.printf("""
                
                **SEARCH FOUND**
                
                Name       : %s
                Roll       : %d
                Marks      : %.1f / 500
                Stream     : %s
                Percentage : %.2f%%
                Grade      : %s
                """,
                    s.getName(),
                    s.getRoll(),
                    s.getMarks(),
                    s.getStreamName(),
                    s.getPercentage(),
                    grade
            );
            return;
        }
        System.out.println("Student not found.");
    }

    // =========================
    //   SAVE DATA IN DOCUMENT
    // ==========================
    public void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // FIXED: Reading clean values out from the map instead of 'students' list
            for (Student s : studentsMap.values()) {
                String line = s.getName() + "," + s.getRoll() + "," + s.getMarks() + "," + s.getStreamCode();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }

    // ==============================
    //   LOADING DATA FROM DOCUMENT
    // ==============================
    public void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int roll = Integer.parseInt(parts[1]);
                    double marks = Double.parseDouble(parts[2]);
                    int streamCode = Integer.parseInt(parts[3]);

                    String streamName = resolveStreamName(streamCode);

                    Student newStudent = new Student(name, roll, marks, streamCode, streamName);
                    studentsMap.put(roll, newStudent);
                }
            }
            System.out.println("Data loaded successfully!");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    // ===================
    //   FIND DATA BY ROLL
    // ===================
    private Student findStudentByRoll(int roll) {
        return studentsMap.get(roll);
    }

    // ===============
    //   UPDATE DATA
    // ===============
    public void updateStudentData() {
        System.out.print("Enter the roll number of the student to update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student targetStudent = findStudentByRoll(roll);

        if (targetStudent == null) {
            System.out.println("Student with roll number " + roll + " not found.");
            return;
        }

        System.out.println("Updating details for: " + targetStudent.getName());

        String newName = getValidName();
        double newMarks = getValidMarks();
        int newStreamCode = getValidStream();
        String newStreamName = resolveStreamName(newStreamCode);

        targetStudent.setName(newName);
        targetStudent.setMarks(newMarks);
        targetStudent.setStreamCode(newStreamCode);
        targetStudent.setStreamName(newStreamName);

        System.out.println("Student details updated successfully in memory!");

        // Auto-save changes to file
        saveStudentsToFile();
    }

    // ===============
    //   DELETE DATA
    // ===============
    public void deleteStudentData() {
        System.out.print("Enter the roll number of the student to delete: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student targetStudent = findStudentByRoll(roll);

        if (targetStudent == null) {
            System.out.println("Student with roll number " + roll + " not found.");
            return;
        }

        System.out.println("Deleting details of: " + targetStudent.getName());
        studentsMap.remove(roll);
        System.out.println("Student " + targetStudent.getName() + "'s details deleted successfully in memory!");

        // FORCE SYNCHRONIZATION TO FILE IMMEDIATELY
        saveStudentsToFile();
    }
}