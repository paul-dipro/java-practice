package PaymentProcessAdvanced;

abstract class AdvancedPayment {
    abstract void pay(double amount);
}

class AdvancedUPI extends AdvancedPayment {
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }
}

class AdvancedCard extends AdvancedPayment {
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Card");
    }
}

class AdvancedNetBanking extends AdvancedPayment {
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via NetBanking");
    }
}

public class PaymentProcessAdvanced {
    static void processPayment(AdvancedPayment p, double amount) {
        p.pay(amount);
    }

    public static void main(String[] args) {
        processPayment(new AdvancedUPI(), 500.0);
        processPayment(new AdvancedCard(), 1200.50);
        processPayment(new AdvancedNetBanking(), 3000.0);
    }
}