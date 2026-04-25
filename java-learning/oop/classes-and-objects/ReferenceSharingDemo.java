class Student {

    int marks;

    void study() {
        System.out.println("Studying...");
    }
}

public class ReferenceSharingDemo {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.marks = 50;

        Student s2 = s1;           
        s2.marks = 80;   
 
        s1.study();

        System.out.println("Marks using s1: " + s1.marks);
        System.out.println("Marks using s2: " + s2.marks);
    }
}
