public class Student extends User {

    private double marks;
    private int streamCode;
    private String streamName;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Student(int userId, String name, String email, double marks, int streamCode, String streamName) {
        super(userId, name, email);
        this.marks = marks;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }

    // =========================
    // CONTRACT IMPLEMENTATIONS (OVERRIDING)
    // =========================

    @Override
    public boolean login(String password) {
        return password.equals("student123");
    }

    @Override
    public void displayDashboard() {
        System.out.printf("""
                
                === STUDENT PORTAL INTERFACE ===
                User ID    : %d
                Name       : %s
                Email      : %s
                Marks      : %.1f / 500
                Stream     : %s
                Percentage : %.2f%%
                """,
                getUserId(),
                getUserName(),
                getEmail(),
                this.marks,
                this.streamName,
                getPercentage()
        );
    }

    // =========================
    // GETTERS & SETTERS
    // =========================
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    public int getStreamCode() { return streamCode; }
    public void setStreamCode(int streamCode) { this.streamCode = streamCode; }

    public String getStreamName() { return streamName; }
    public void setStreamName(String streamName) { this.streamName = streamName; }

    public double getPercentage() {
        return (marks / 500.0) * 100;
    }
}