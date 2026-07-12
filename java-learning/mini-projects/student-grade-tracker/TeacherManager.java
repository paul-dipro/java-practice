import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TeacherManager {

    private final HashMap<Integer, User> usersMap = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    static {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
    }

    // =========================
    // COLLECT TEACHER DATA
    // =========================
    public void collectTeachers() {
        int totalTeachers = getValidTeacherCount();

        for (int i = 0; i < totalTeachers; i++) {
            System.out.println("\n========== Teacher " + (i + 1) + " ==========");
            int userId = getValidUserId();
            String name = getValidName();
            String email = getValidEmail();
            String schoolName = getValidSchoolName();
            double salary = getValidSalary();
            String status = getValidStatus();

            Teacher newTeacher = new Teacher(userId, name, email, schoolName, salary, status);
            usersMap.put(userId, newTeacher);
            saveTeacherToDatabase(userId, name, email, schoolName, salary, status);
        }
    }

    // =========================
    // DISPLAY ALL TEACHERS
    // =========================
    public void displayAllTeachers() {
        if (usersMap.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }

        System.out.println("\n========== TEACHER DETAILS ==========");
        for (User u : usersMap.values()) {
            if (u instanceof Teacher t) {

                System.out.printf("""
                === TEACHER PORTAL INTERFACE ===
                User ID          : %d
                Name             : %s
                Email            : %s
                School Name      : %s
                Salary           : %.2f
                Status           : %s
                """,
                        t.getUserId(),
                t.getUserName(),
                t.getEmail(),
                t.getSchoolName(),
                t.getSalary(),
                t.getStatus()
                );
            }
        }
    }

    // =========================
    // VALIDATIONS
    // =========================
    private int getValidUserId() {
        while (true) {
            System.out.print("User Id: ");
            try {
                int userId = sc.nextInt();
                sc.nextLine();

                boolean isDuplicate = usersMap.containsKey(userId);

                if (userId > 0 && !isDuplicate) {
                    return userId;
                }
                System.out.println("User Id must be positive and unique.");
            } catch (InputMismatchException e) {
                System.out.println("Numbers only.");
                sc.nextLine();
            }
        }
    }

    private int getValidTeacherCount() {
        int count;
        while (true) {
            System.out.print("Enter number of teachers: ");
            try {
                count = sc.nextInt();
                sc.nextLine();
                if (count > 0) {
                    return count;
                }
                System.out.println("Invalid! Teacher count must be greater than 0.");
            } catch (InputMismatchException e) {
                System.out.println("Numbers only.");
                sc.nextLine();
            }
        }
    }

    private String getValidName() {
        while (true) {
            System.out.print("\nEnter teacher name: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name.toUpperCase();
            }
            System.out.println("Name cannot be empty.");
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

    private String getValidSchoolName() {
        while (true) {
            System.out.print("\nEnter school name: ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name.toUpperCase();
            }
            System.out.println("Name cannot be empty.");
        }
    }

    private double getValidSalary() {
        double salary;
        while (true) {
            System.out.print("Enter salary(monthly): ");
            salary = sc.nextDouble();
            sc.nextLine();

            if (salary >= 0 && salary <= 1000000000) {
                return salary;
            }
            System.out.println("Salary amount exceeds! Check Again!");
        }
    }

    private String getValidStatus() {
        while (true) {
            System.out.print("\nStatus(working/retire/leave/suspended): ");
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name.toUpperCase();
            }
            System.out.println("Status cannot be empty.");
        }
    }

    // ==================
    // SEARCH TEACHER
    // ==================
    public void searchByTeacherId(int userId) {
        Teacher t = searchByUserId(userId);

        if (t != null) {
            System.out.printf("""
                
                **SEARCH FOUND**
                
                User Id      : %d
                Name         : %s
                Email        : %s
                School Name  : %s
                Salary       : %.2f
                Status       : %s
                """,
                    t.getUserId(),
            t.getUserName(),
            t.getEmail(),
            t.getSchoolName(),
            t.getSalary(),
            t.getStatus()
            );
            return;
        }
        System.out.println("Teacher not found.");
    }

    // =========================
    //   SAVE DATA IN DATABASE
    // ==========================
    public void saveTeacherToDatabase(int userId, String name, String email, String schoolName, double salary, String status) {
        String sql = "INSERT INTO teachers (user_id, name, email, school_name, salary, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, schoolName);
            pstmt.setDouble(5, salary);
            pstmt.setString(6, status);

            pstmt.executeUpdate();
            System.out.println("Teacher records synced to PostgreSQL database successfully.");

        } catch (SQLException e) {
            System.err.println("Database sync error: " + e.getMessage());
        }
    }

    // ==============================
    //   LOADING DATA FROM DATABASE
    // ==============================
    public void loadTeachersFromDataBase() {
        String sql = "SELECT user_id, name, email, school_name, salary, status FROM teachers";

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String schoolName = rs.getString("school_name");
                double salary = rs.getDouble("salary");
                String status = rs.getString("status");

                Teacher newTeacher = new Teacher(userId, name, email, schoolName, salary, status);
                usersMap.put(userId, newTeacher);
            }
            System.out.println("Data loaded successfully from PostgreSQL!");
        } catch (SQLException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    // ===================
    //   FIND DATA BY USER ID
    // ===================
    private Teacher searchByUserId(int userId) {
        User u = usersMap.get(userId);

        if (u instanceof Teacher t) {
            return t;
        }
        return null;
    }

    // ===============
    //   UPDATE DATA
    // ===============
    public void updateTeacherDataBase() {
        String sql = "UPDATE teachers SET name = ?, email = ?, school_name = ?, salary = ? , status = ? WHERE user_id = ?";

        System.out.print("Enter the userId of the teacher to update: ");
        int userId = sc.nextInt();
        sc.nextLine();

        Teacher targetTeacher = searchByUserId(userId);

        if (targetTeacher == null) {
            System.out.println("Teacher with user id " + userId + " not found.");
            return;
        }

        System.out.println("Updating details for: " + targetTeacher.getUserName());

        String newName = getValidName();
        String newEmail = getValidEmail();
        String newSchoolName = getValidSchoolName();
        double newSalary = getValidSalary();
        String newStatus = getValidStatus();

        targetTeacher.setUserName(newName);
        targetTeacher.setEmail(newEmail);
        targetTeacher.setSchoolName(newSchoolName);
        targetTeacher.setSalary(newSalary);
        targetTeacher.setStatus(newStatus);

        System.out.println("Teacher details updated successfully in memory!");

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, newSchoolName);
            pstmt.setDouble(4, newSalary);
            pstmt.setString(5, newStatus);
            pstmt.setInt(6, userId);

            pstmt.executeUpdate();
            System.out.println("Teacher details synchronized to PostgreSQL successfully!");
        } catch (SQLException e) {
            System.err.println("Database update error: " + e.getMessage());
        }
    }

    // ===============
    //   DELETE DATA
    // ===============
    public void deleteTeacherDataBase() {
        String sql = "DELETE FROM teachers WHERE user_id = ?";

        System.out.print("Enter the userId of the teacher to delete: ");
        int userId = sc.nextInt();
        sc.nextLine();

        Teacher targetTeacher = searchByUserId(userId);

        if (targetTeacher == null) {
            System.out.println("Teacher with user id " + userId + " not found.");
            return;
        }

        System.out.println("Deleting details of: " + targetTeacher.getUserName());
        usersMap.remove(userId);
        System.out.println("Teacher " + targetTeacher.getUserName() + "'s details deleted successfully in memory!");

        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            pstmt.executeUpdate();
            System.out.println("Teacher details deleted from PostgreSQL successfully!");

        } catch (SQLException e) {
            System.err.println("Database update error: " + e.getMessage());
        }
    }
}