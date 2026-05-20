public class Main {
    public static void main(String[] args) {
        System.out.println("===== STUDENT GRADE TRACKER =====");

        StudentManager manager = new StudentManager();
        manager.collectStudents();
        manager.displayAllStudents();
        manager.displayAverage();
    }
}