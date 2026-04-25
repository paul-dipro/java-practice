class TypeCastingDemo {
    public static void main(String[] args) {

        int a = 10;
        double b = a;
        System.out.println("Implicit (int to double): " + b);

        double x = 9.78;
        int y = (int) x;
        System.out.println("Explicit (double to int): " + y);

        int p = 5;
        int q = 2;

        double result1 = p / q;
        double result2 = (double) p / q;


        System.out.println("Integer division happens before assignment");
        System.out.println("Without casting: " + result1);
        System.out.println("With casting: " + result2);

        
        double price = 199.99;
        int finalPrice = (int) price;
        System.out.println("After conversion (data loss): " + finalPrice);
        
    }
}