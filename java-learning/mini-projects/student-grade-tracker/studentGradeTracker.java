import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private double marks;
    private int streamCode;
    private String streamName;

    public Student(String name, double marks, int streamCode, String streamName){
        this.name = name;
        this.marks = marks;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }


    public void setStudentName(String name){
        this.name = name;
    }

    public void setStudentMarks(double marks){
        this.marks = marks;
    }

    public void setStudentStream(int stream){
        this.streamCode = streamCode;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    String getStudentName(){
        return this.name;
    }

    double getStudentMarks(){
        return this.marks;
    }

    public int getStreamCode() {
        return this.streamCode;
    }


    public String getStreamName() {
        return this.streamName;
    }

}

public class studentGradeTracker {
    public static void main(String[] args){

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students in the school: ");
        int n = sc.nextInt();
        sc.nextLine();

       for(int i = 0; i < n; i++){

           System.out.print("\nEnter student's name: ");
           String name = sc.nextLine().toUpperCase().trim();

           double marks = 0; // Variable assigned for accepting input for marks
           while(true) {
               System.out.print("Enter student's marks out of 500: ");
               marks = sc.nextDouble();

               if (marks < 0 || marks > 500) {
                   System.out.println("Invalid Input!(Should be under 0 - 500)");
               } else {
                   break;
               }
               sc.nextLine();
           }

           int streamCode = 0;
           String streamName = "";
           boolean isValid = true;

           while(isValid) {
               System.out.print("Select student's stream\n1. Science \n2. Arts \n3.Commerce \nChoose a option: ");
               streamCode = sc.nextInt();

               switch(streamCode){
                   case 1:
                       streamName = "SCIENCE";
                       isValid = false;
                       break;
                   case 2:
                       streamName = "ARTS";
                       isValid = false;
                       break;
                   case 3:
                       streamName = "COMMERECE";
                       isValid = false;
                       break;
                   default:
                       System.out.println("Invalid option! Select(1 / 2 / 3)");

               }
           }

           students.add(new Student(name, marks, streamCode, streamName));


       }

            for (Student s : students) {
                System.out.println("\nName: " + s.getStudentName() +
                        "\nMarks: " + s.getStudentMarks() +
                        "\nStream: " + s.getStreamName());
            }


        double totalMarks = 0;

        for (Student s : students) {
            totalMarks += s.getStudentMarks();
        }

        double average = totalMarks / students.size();

        System.out.println("\nThe average marks of the school: " + average);

    }
}