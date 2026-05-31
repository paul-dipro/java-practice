import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== STUDENT GRADE TRACKER =====");

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("""
                    \n_______________
                    
                         MENU
                    _______________
                    \n1. Add Students
                    2. Search Student
                    3. Display All
                    4. Average
                    5. Exit
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
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}