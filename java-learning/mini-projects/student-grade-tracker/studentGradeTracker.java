import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks){
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }


    public void setStudentName(String name){
        this.name = name;
    }

    public void setStudentMarks(double marks){
        this.marks = marks;
    }

    String getStudentName(){
        return this.name;
    }

    double getStudentMarks(){
        return this.marks;
    }

}

public class studentGradeTracker {
    public static void main(String[] args){

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();



       for(int i = 0; i < n; i++){

           System.out.print("\nEnter student's name: ");
           String name = sc.nextLine();

           System.out.print("Enter student's marks: ");
           double marks = sc.nextDouble();

           System.out.print("Enter student's grade: ");
           char grade = sc.next().charAt(0);

           students.add(new Student(name, marks, grade));


           sc.nextLine();
       }
       }

        for (Student s : students) {
            System.out.println("Name: " + s.getStudentName() + " | Grade: " + s.getStudentGrade());
        }

        for (Student s : students) {
            System.out.println("Name: " + s.getStudentName() + " | Grade: " + s.getStudentGrade());
        }

        double totalMarks = 0;

        for (Student s : students) {
            totalMarks += s.getStudentMarks();
        }

        double average = totalMarks / students.size();

        System.out.println("The average marks of the class: " + average);

    }
}