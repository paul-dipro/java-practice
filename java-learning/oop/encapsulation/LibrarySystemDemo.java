import java.util.Scanner;

 class Book {

    String title;
    int pageCount;
    static final int MIN_PAGE = 5;

 Book(String title, int pageCount) {
    this.title = title;
    setPage(pageCount);
    
}

private void setTitle(String title) {
    
    this.title = title;
}
    

 private  void setPage(int pageCount) {

    if(pageCount < 0) {

     this.pageCount = MIN_PAGE;

    } else {
     
     this.pageCount = pageCount;
    }

}

 String getTitle() {
 
    return  this.title;
}

 int getPage() {

    return  this.pageCount;
}

}

 public class LibrarySystemDemo {
   public static void main(String[] args) {
 
     Scanner sc = new Scanner(System.in);

     System.out.print("Books no.: ");
     int b = sc.nextInt();
     Book[] books = new Book[b];
     sc.nextLine();

     for(int i = 0; i < books.length; i++) {

     System.out.print("Index " + i + " Book's Title: ");
     String t = sc.nextLine();

     System.out.print("Index " + i + " Book's Pages Number Total: ");
     int p = sc.nextInt();
     sc.nextLine();

     books[i] = new Book(t,p);

    
     }

     for (int i = 0; i < b; i++) {
            System.out.println("Index " + i + " Book's Name  -> " +
                    books[i].getTitle() + "  Total Page ->  " +
                    books[i].getPage());
        }

        sc.close();
    }
}

     

     
      
