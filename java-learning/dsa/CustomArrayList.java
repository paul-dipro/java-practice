public class CustomArrayList {

    private int[] data;
    private int size;

    public CustomArrayList() {
        data = new int[5];
        size = 0;
    }

    public void add(int value) {
        data[size] = value;
        size++;
    }

    public void display() {
        for(int i = 0; i < size; i++) {
                System.out.println(data[i]);
        }
    }
}

 class Main {

    public static void main(String[] args) {

        CustomArrayList list = new CustomArrayList();

        list.add(10);
        list.add(20);
        list.add(30);

        list.display();

    }
}