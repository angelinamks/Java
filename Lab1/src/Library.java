import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        for (Book b : books) {
            if ((b.ISBN.equals(book.ISBN)) || b.title.equals(book.title)) {
                return false;
            }
        }

        books.add(book);
        return true;
    }


    public ArrayList<Book> booksList(){
        return books;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public boolean removeBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.ISBN.equals(isbn)) {
                books.remove(book);
                return true;
            }
        }

        return false;
    }
}
