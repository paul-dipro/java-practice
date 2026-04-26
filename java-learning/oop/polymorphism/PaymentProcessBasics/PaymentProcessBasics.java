package PaymentProcessBasics;


abstract class BasicPayment {
    abstract void pay();
}

class BasicUPI extends BasicPayment {
    @Override
    void pay() {
        System.out.println("Pay Via UPI!");
    }
}

class BasicCard extends BasicPayment {
    @Override
    void pay() {
        System.out.println("Pay Via Card!");
    }
}

class BasicNetBanking extends BasicPayment {
    @Override
    void pay() {
        System.out.println("Pay Via NetBanking!");
    }
}

public class PaymentProcessBasics {

    // This is a helper method to demonstrate polymorphism
    static void processPayment(BasicPayment p) {
        p.pay();
    }

    // main method to run the code!
    public static void main(String[] args) {
        processPayment(new BasicUPI());
        processPayment(new BasicCard());
        processPayment(new BasicNetBanking());
    }
}