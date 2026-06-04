public class Main {
    public static void main(String[] args) {

        LogMonitor monitor = new LogMonitor();

        Log log1 = new Log("2026-06-04 23:00:01", "INFO", "Server started successfully.");
        Log log2 = new Log("2026-06-04 23:02:15", "ERROR", "Database connection failed!");
        Log log3 = new Log("2026-06-04 23:05:40", "WARN", "Memory usage exceeding 80%.");
        Log log4 = new Log("2026-06-04 23:06:12", "ERROR", "Unauthorized access attempt detected.");

        monitor.addLog(log1);
        monitor.addLog(log2);
        monitor.addLog(log3);
        monitor.addLog(log4);

        System.out.println("--- Detecting Critical Server Errors ---");
        monitor.showErrors();

    }
}