public class Teacher extends User {

    // Only teacher-specific fields stay here.
    private String schoolName;
    private double salary;
    private String status;

    public Teacher(int userId, String name, String email, String schoolName, double salary, String status) {
        super(userId, name, email);
        this.schoolName = schoolName;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public boolean login(String password) {
        // Enforcing the Authenticatable contract with a mock password check
        return password.equals("teacher123");
    }

    @Override
    public void displayDashboard() {
        // Enforcing the abstract User rule. This handles the reporting logic polymorphically!
        System.out.printf("""
                
                === TEACHER PORTAL INTERFACE ===
                User ID          : %d
                Name             : %s
                Email            : %s
                School Name      : %s
                Salary           : %s
                Status           : %s
                """,
                getUserId(),      // Inherited from User
                getUserName(),    // Inherited from User
                getEmail(),       // Inherited from User
                this.schoolName,
                this.salary,
                this.status
        );
    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}