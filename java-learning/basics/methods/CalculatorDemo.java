import java.util.Scanner;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    boolean isEven(int n) {
        return n % 2 == 0;
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        String op;

        while (true) {
            System.out.print("Enter operation (+ or *): ");
            op = sc.next();

            if (op.equals("+") || op.equals("*")) {
                break;
            } else {
                System.out.println("Invalid operator. Try again.");
            }
        }

        int result = 0;

        if (op.equals("+")) {
            result = calc.add(x, y);
        } else {
            result = calc.multiply(x, y);
        }

        System.out.println("Result: " + result);
        System.out.println("Is even? " + calc.isEven(result));

        sc.close();
    }
}