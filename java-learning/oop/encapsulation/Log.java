public class Log {

    private String timestamp;
    private String severity;
    private String message;

    public Log(String timestamp, String severity, String message) {

        this.timestamp = timestamp;
        this.severity = severity;
        this.message = message;
    }

    public String getTimestamp() {

        return this.timestamp;
    }

    public String getSeverity() {

        return this.severity;
    }

    public String getMessage() {

        return this.message;
    }
}