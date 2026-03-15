public class AddTwo {
    static int add(int x, int y){
        return x + y;
    }
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        int c = add(a, b);
        System.out.println(c);   // expect 7
    }
}