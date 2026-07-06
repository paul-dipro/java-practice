import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== STUDENT GRADE TRACKER =====");

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        //Loading data at frist
        manager.loadStudentsFromDataBase();

        while (true) {
            System.out.println("""
                  \n_______________
                    
                         MENU
                   _______________
                   \n
                    1. Add Students
                    2. Search Student
                    3. Display All
                    4. Average
                    5. Update Data
                    6. Delete Data
                    7. Save/Exit
                    """);

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.collectStudents();
                case 2 -> {
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    manager.searchByRoll(roll);
                }
                case 3 -> manager.displayAllStudents();
                case 4 -> manager.displayAverage();
                case 5 -> manager.updateStudentDataBase();
                case 6 -> manager.deleteStudentDataBase();
                case 7 -> {
                    System.out.println("Exiting application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}