package data;

 public class Message implements Printer<String> {
     private String message;

     public Message(String message) {
           this.message = message;
     }

     @Override
     public String printData() {
         return message;
     }
 }