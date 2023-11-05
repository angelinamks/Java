import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        boolean firstBook = library.addBook(new Book("First name", "Author №1", "ISBN1", 2018));
        if(!firstBook){
            System.out.println("First book was not added due to duplicate");
        }
        boolean secondBook = library.addBook(new Book("Second name", "Author №2", "ISBN2", 2016));
        if(!secondBook){
            System.out.println("Second book was not added due to duplicate");
        }

        ArrayList<Book> books = library.booksList();
        System.out.println("Total books: " + books.size() + '\n' + "Books: " + books);

        Book foundBook = library.findBookByTitle("First name");
        if (foundBook != null) {
            System.out.println("Book was found: " + foundBook);
        } else {
            System.out.println("Book was not found");
        }

        if (library.removeBookByISBN("ISBN2")) {
            System.out.println("Book was removed");
        } else {
            System.out.println("Book was not found");
        }

        System.out.println("Books remaining: " + books.size() + '\n' + "Books: " + books);
    }
}