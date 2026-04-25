import java.util.Scanner;

class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPrice(double price) {
        this.price = price;
    }

    String getName() {
        return this.name;
    }

    double getPrice() {
        return this.price;
    }
}

public class InventorySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Index " + i + " Item Name: ");
            String m = sc.next();

            System.out.println("Index " + i + " Item Price: ");
            double p = sc.nextDouble();

            items[i] = new Item(m, p);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Index " + i + " Name  -> " +
                    items[i].getName() + " Price ->  " +
                    items[i].getPrice());
        }

        sc.close();
    }
}