 abstract class Payment{

    abstract void pay();
}

 class UPI extends Payment {
    @Override
    void pay() {
       System.out.println("Pay Via UPI!");
   }
}

class Card extends Payment {
    @Override
    void pay() {
        System.out.println("Pay Via Card!");
    }
}

 class NetBanking extends Payment {
    @Override
     void pay() {
        System.out.println("Pay Via NetBanking!");
    }
 }

 public class PaymentProcess {

     static void processPayment(Payment p) {   // INSIDE class
         p.pay();
     }

     public static void main(String[] args) {

         processPayment(new UPI());
         processPayment(new Card());
         processPayment(new NetBanking());

     }
 }