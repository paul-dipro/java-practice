public class Student {

    // =========================
    // FIELDS
    // =========================
    private int menuCode;
    private String menuName;
    private String name;
    private double marks;
    private int streamCode;
    private String streamName;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Student(int menuCode, String menuName, String name, double marks, int streamCode, String streamName) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.name = name;
        this.marks = marks;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }

    // =========================
    // SETTERS
    // =========================
    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setName(String name) {
        this.name = name;
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

    public int menuCode() {
        return menuCode;
    }

    public String menuName() {
        return menuName;
    }

    public String getName() {
        return name;
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