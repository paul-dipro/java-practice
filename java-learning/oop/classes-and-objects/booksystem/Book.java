package booksystem;

public class Book {

    private String title;
    private int pages;

    public Book(String t, int p) {
        title = t;
        pages = p;
    }

    public int getPages() {
        return pages;
    }


    public void display() {
        System.out.println(title + " - " + pages);
    }

    public static int calculateTotalPages(Book[] books) {
        int sum = 0;
        for (Book b : books) {
            if (b != null) {
                sum += b.getPages();
            }
        }
        return sum;
    }
    }


