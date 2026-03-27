class Student {

    int marks;

   void setMarks(int m) {

       marks = m;
}

    int getMarks() {

          return marks;
    }
}
public class StudentArrayOOPDemo {
     public static void main(String[] args) {

        Student[] students = new Student[5];
            
          for(int i = 0; i < students.length; i++) {

             if(i % 2 == 0) {
     
                students[i] = new Student();
                students[i].setMarks(i * 10);        
              }
            } 
            for(int i = 0; i < students.length; i++) {

             if(students[i] != null) { 

                System.out.println("Index " + i + ": " + students[i].getMarks());
                
                        
              } else {
                 System.out.println("Index " + i + ": No Student");
            }
          }


         }
}