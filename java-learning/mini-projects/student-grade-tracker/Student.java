public class Student {

    // =========================
    // FIELDS
    // =========================
    private String name;
    private int roll;
    private double marks;
    private int streamCode;
    private String streamName;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Student(String name, int roll, double marks, int streamCode, String streamName) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }

    // =========================
    // SETTERS
    // =========================

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setStreamCode(int streamCode) {
        this.streamCode = streamCode;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    // =========================
    // GETTERS
    // =========================

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public double getMarks() {
        return marks;
    }

    public int getStreamCode() {
        return streamCode;
    }

    public String getStreamName() {
        return streamName;
    }

    // =========================
    // PERCENTAGE CALCULATING USING BUSINESS METHOD
    // =========================
    public double getPercentage() {
        return (marks / 500.0) * 100;
    }
}