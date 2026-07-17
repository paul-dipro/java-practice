import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();

        studentManager.loadStudentsFromDataBase();
        teacherManager.loadTeachersFromDataBase();

        while (true) {
            System.out.println("""
                    \n===== MAIN PORTAL =====
                    1. Manage Students
                    2. Manage Teachers
                    3. Exit
                    """);
            System.out.print("Select domain: ");
            int domainChoice = sc.nextInt();

            if (domainChoice == 3) {
                System.out.println("Exiting application. Goodbye!");
                return;
            }

            if (domainChoice == 1) {
                runStudentMenu(sc, studentManager);
            } else if (domainChoice == 2) {
                runTeacherMenu(sc, teacherManager);
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private static void runStudentMenu(Scanner sc, StudentManager manager) {
        while (true) {
            System.out.println("""
                    \n_______________
                    
                     STUDENT MENU
                     _______________
                     \n
                      1. Add Students
                      2. Search Student
                      3. Display All
                      4. Average
                      5. Update Data
                      6. Delete Data
                      7. Return to Main Portal
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
                    System.out.println("Returning to Main Portal...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void runTeacherMenu(Scanner sc, TeacherManager manager) {
        while (true) {
            System.out.println("""
                \n_______________
                
                 TEACHER MENU
                 _______________
                 \n
                  1. Add Teachers
                  2. Search Teacher
                  3. Display All
                  4. Update Data
                  5. Delete Data
                  6. Return to Main Portal
                """);

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.collectTeachers();
                case 2 -> {
                    System.out.print("Enter UserId: ");
                    int userId = sc.nextInt();

                    //manager.userId(userId);
                }
                case 3 -> manager.displayAllTeachers();
                case 4 -> manager.updateTeacherDataBase();
                case 5 -> manager.deleteTeacherDataBase();
                case 6 -> {
                    System.out.println("Returning to Main Portal...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}