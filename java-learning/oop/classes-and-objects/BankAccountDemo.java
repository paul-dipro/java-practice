class BankAccount {

    int balance;

    BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    void deposit(int amount) {
        this.balance += amount;
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    int getBalance() {
        return this.balance;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        account.deposit(500);     
        account.withdraw(300);   
        account.withdraw(2000);   

        System.out.println("Final Balance: " + account.getBalance());
    }
}