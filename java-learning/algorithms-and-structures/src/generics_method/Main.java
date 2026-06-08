package generics_method;

public class Main {

    public static <T> boolean  isDouble(T object) {
    return object instanceof Double;
}
    public static void main(String[] args) {
        Object test1 = 15.5;
        Object test2 = "Java";
        Object test3 = 100;

        boolean isTest1Double = isDouble(test1);
        boolean isTest2Double = isDouble(test2);
        boolean isTest3Double = isDouble(test3);

        System.out.println(isTest1Double);
        System.out.println(isTest2Double);
        System.out.println(isTest3Double);

    }
}