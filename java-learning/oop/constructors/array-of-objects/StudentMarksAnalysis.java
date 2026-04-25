import java.util.Scanner;

class Student {
    int marks;

    void setMarks(int m) {
        marks = m; 
    }

    int getMarks() {
        return marks;
    }

    boolean isPass() {
        return marks >= 40;
    }
}

public class StudentMarksAnalysis {
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      System.out.println("Enter number of students: ");
      int n = sc.nextInt();

      Student[] students = new Student[n];

      int countPass = 0;
      int countFail = 0;

      for(int i = 0; i < students.length; i++) {
         students[i] = new Student();
         System.out.println("Enter marks for student " + (i + 1) + ": ");
         students[i].setMarks(sc.nextInt());
         
         
         if(students[i].isPass()) {
           System.out.println("Result: Pass");
           countPass++;
         } else {
            System.out.println("Result: Fail");
            countFail++;
         }
       
       } 
      for(int j = 0; j < students.length; j++) {
           System.out.println("Student " + (j + 1) + " | Marks: " + students[j].getMarks() + 
                   " | Status: " + (students[j].isPass() ? "Pass" : "Fail"));
        
  } 
         System.out.println("\n--- Final Statistics ---");

         System.out.println("Total students passed: " + countPass);
         System.out.println("Total students failed: " + countFail);
         sc.close();
}
}
      
      

