class Student {
    
     int marks;

}

public class StudentArrayEvenIndexDemo {
    public static void main(String[] args) {


    Student[] student = new Student[5];

    for(int i = 0; i < student.length; i++) {

    if(i % 2 == 0) {
        student[i] = new Student();
        student[i].marks = i * 10;
    }

}


   for(int i = 0; i < student.length; i++) {

     if(student[i] != null){
       System.out.println(student[i].marks);
     } else {
       System.out.println("No Students");
     }
 
     

   }
  }
}
       
