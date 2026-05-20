public class Student {
    private String name;
    private double marks;
    private int streamCode;
    private String streamName;

    public Student(String name, double marks, int streamCode, String streamName) {
        this.name = name;
        this.marks = marks;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }


    public void setStudentName(String name) {
        this.name = name;
    }
    public void setStudentMarks(double marks) {
        this.marks = marks;
    }
    public void setStudentStream(int streamCode) {
        this.streamCode = streamCode;
    }
    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }


    public String getStudentName() {
        return this.name;
    }
    public double getStudentMarks() {
        return this.marks;
    }
    public int    getStreamCode() {
        return this.streamCode;
    }
    public String getStreamName() {
        return this.streamName;
    }


    public double getPercentage() {
        return (this.marks / 500.0) * 100;
    }
}