// Practice: Array of Objects, NullPointerException behavior, reference sharing

class Dogs {
     
      int age;

}
  public class ArrayObj {
     public static void main(String[] args) {
         
         Dogs[] dogs = new Dogs[3];
          
         dogs[2] = new Dogs();
         dogs[2].age = 5;
    
         if(dogs[1] != null) {
              System.out.println(dog[1].age);
         }else{
             System.out.println("It's null");
         }
         
         System.out.println(dogs[2]);
         System.out.println(dogs[2].age);
         System.out.println(dogs[1]);

     }
}
