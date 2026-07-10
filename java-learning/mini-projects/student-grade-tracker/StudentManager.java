import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
//FILE HANDLING USING PostgreSQL IMPORTS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentManager {

    // 1. ALL FIELDS AT THE TOP
    private final GradeSystem gradeSystem = new GradeSystem();
    private HashMap<Integer, User> usersMap = new HashMap<>();

    static {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
    }

    private final Scanner sc = new Scanner(System.in);

    //==========================================================
    //Private helper method to open a secure channel
    // to my running database
    //============================================================

    private Connection connect() throws SQLException {

        String url = "jdbc:postgresql://127.0.0.1:5433/student_manager_db";
        String user = "student_admin";
        String password = "Admin123";

        return DriverManager.getConnection(url, user, password);
    }



     // =========================
    // COLLECT STUDENT DATA
    // =========================
    public void collectStudents() {
        int totalStudents = getValidStudentCount();

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\n========== STUDENT " + (i + 1) + " ==========");
            String name = getValidName();
            int roll    = getValidRoll();
            String email = getValidEmail();
            double marks = getValidMarks();

            int streamCode = getValidStream();
            String streamName = resolveStreamName(streamCode);

            Student newStudent = new Student(roll, name, email, marks, streamCode, streamName);
            usersMap.put(roll, newStudent);

            saveStudentToDatabase(roll, name, email, marks, streamCode);
        }
    }

    // =========================
    // DISPLAY ALL STUDENTS
    // =========================
    public void displayAllStudents() {
        if (usersMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT REPORT ==========");
        for (User u : usersMap.values()) {
            if (u instanceof Student s) {
                String grade = gradeSystem.getGrade(s.getMarks());

                System.out.printf("""
                                
                                Name       : %s
                                Roll       : %d
                                Marks      : %.1f / 500
                                Stream     : %s
                                Percentage : %.2f%%
                                Grade      : %s
                                """,
                        s.getUserName(),
                        s.getUserId(),
                        s.getMarks(),
                        s.getStreamName(),
                        s.getPercentage(),
                        grade
                );
            }
        }
    }

    // =========================
    // DISPLAY CLASS AVERAGE
    // =========================
    public void displayAverage() {
        // FIXED: Using studentsMap instead of deleted 'students' list
        if (usersMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalMarks = 0;
        int studentCount = 0;
        for (User u : usersMap.values()) {
            if (u instanceof Student s) {
                totalMarks += s.getMarks();
                studentCount++;
            }
        }

        double average = 0;
        if (studentCount > 0) {
            average = totalMarks / studentCount;
        }

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
                boolean isDuplicate = usersMap.containsKey(roll);

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

    private String getValidEmail() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        while (true) {
            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();
            if (email.matches(emailRegex)) {
                return email.toLowerCase();
            }
            System.out.println("Invalid email format! Example: student@domain.com");
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
                    s.getUserName(),
                    s.getUserId(),
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
    //   SAVE DATA IN DATABASE
    // ==========================

    public void saveStudentToDatabase(int rollNumber, String name, String email, double marks, int streamCode) {
        String sql = "INSERT INTO students (roll_number, name, email, marks, stream_code) VALUES (?, ?, ?, ?, ?, ?)";

        // Try-with-resources automatically closes the connection and statement when done
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Safety parameters to prevent SQL injection
            pstmt.setInt(1, rollNumber);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setDouble(4, marks);
            pstmt.setInt(5, streamCode);

            pstmt.executeUpdate();
            System.out.println("Student records synced to PostgreSQL database successfully.");

        } catch (SQLException e) {
            System.err.println("Database sync error: " + e.getMessage());
        }
    }

    // ==============================
    //   LOADING DATA FROM DATABASE
    // ==============================
    public void loadStudentsFromDataBase() {
        String sql = "SELECT roll_number, name, email, marks, stream_code FROM students";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                    int roll = rs.getInt("roll_number");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    double marks = rs.getDouble("marks");
                    int streamCode = rs.getInt("stream_code");

                    String streamName = resolveStreamName(streamCode);

                    Student newStudent = new Student(roll, name, email, marks, streamCode, streamName);
                    usersMap.put(roll, newStudent);
            }
            System.out.println("Data loaded successfully from PostgreSQL!");
        } catch (SQLException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    // ===================
    //   FIND DATA BY ROLL
    // ===================
    private Student findStudentByRoll(int roll) {
        User u = usersMap.get(roll); // Pull the generic user out

        // Check if the user exists and is actually a Student
        if (u instanceof Student s) {
            return s; // Safely return the matched Student object
        }

        return null; // Return null if not found or if it belongs to a Teacher
    }

    // ===============
    //   UPDATE DATA
    // ===============
    public void updateStudentDataBase() {

        String sql = "UPDATE students SET name = ?, email = ?, marks = ?, stream_code = ? WHERE roll_number = ?";

        System.out.print("Enter the roll number of the student to update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student targetStudent = findStudentByRoll(roll);

        if (targetStudent == null) {
            System.out.println("Student with roll number " + roll + " not found.");
            return;
        }

        System.out.println("Updating details for: " + targetStudent.getUserName());

        String newName = getValidName();
        String newEmail = getValidEmail();
        double newMarks = getValidMarks();
        int newStreamCode = getValidStream();
        String newStreamName = resolveStreamName(newStreamCode);

        targetStudent.setUserName(newName);
        targetStudent.setMarks(newMarks);
        targetStudent.setStreamCode(newStreamCode);
        targetStudent.setStreamName(newStreamName);
        targetStudent.setEmail(newEmail);

        System.out.println("Student details updated successfully in memory!");

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setDouble(3, newMarks);
            pstmt.setInt(4, newStreamCode);
            pstmt.setInt(5, roll); // The WHERE clause parameter

            pstmt.executeUpdate();
            System.out.println("Student details synchronized to PostgreSQL successfully!");

        } catch (SQLException e) {
            System.err.println("Database update error: " + e.getMessage());
        }
    }

    // ===============
    //   DELETE DATA
    // ===============
    public void deleteStudentDataBase() {

        String sql = "DELETE FROM students WHERE roll_number = ?";

        System.out.print("Enter the roll number of the student to delete: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student targetStudent = findStudentByRoll(roll);

        if (targetStudent == null) {
            System.out.println("Student with roll number " + roll + " not found.");
            return;
        }

        System.out.println("Deleting details of: " + targetStudent.getUserName());
        usersMap.remove(roll);
        System.out.println("Student " + targetStudent.getUserName() + "'s details deleted successfully in memory!");

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, roll);

            pstmt.executeUpdate();
            System.out.println("Student details deleted from PostgreSQL successfully!");

        } catch (SQLException e) {
            System.err.println("Database update error: " + e.getMessage());
        }
    }
}