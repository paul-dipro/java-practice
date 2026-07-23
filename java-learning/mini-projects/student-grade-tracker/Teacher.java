public class Teacher extends User {

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

        return password.equals("teacher123");
    }

    @Override
    public void displayDashboard() {

        System.out.printf("""
                
                === TEACHER PORTAL INTERFACE ===
                User ID          : %d
                Name             : %s
                Email            : %s
                School Name      : %s
                Salary           : %s
                Status           : %s
                """,
                getUserId(),
                getUserName(),
                getEmail(),
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