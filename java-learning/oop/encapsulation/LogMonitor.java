import java.util.ArrayList;

public class LogMonitor {

    private ArrayList<Log> logList;

    public LogMonitor() {
        this.logList = new ArrayList<Log>();
    }

    public void addLog(Log log) {
        this.logList.add(log);
    }

    public void showErrors() {

     for (Log l : logList) {

         if (l.getSeverity().equals("ERROR")) {

             System.out.println(l.getMessage());
         }
     }
    }
}