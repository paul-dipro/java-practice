package booksystem;

public class Main{
    public static void main(String[] args){
        Book[] books = new Book[5];


        books[0] = new Book("The Great Gatsby", 180);
        books[1] = new Book("1984", 328);

        for (Book b : books) {
            if (b != null) {
                b.display();
            }

        }
        int total = Book.calculateTotalPages(books);
        System.out.println("Total pages: " + total);

    }
}