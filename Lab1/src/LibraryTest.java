import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibraryTest {

    @Test
    void testAddBook() {
        Library library = new Library();
        assertTrue(library.addBook(new Book("First name", "Author №1", "ISBN1", 2018)));
        assertFalse(library.addBook(new Book("First name", "Author №1", "ISBN1", 2018)));
        assertTrue(library.addBook(new Book("Second name", "Author №2", "ISBN2", 2016)));
    }

    @Test
    void testBooksList() {
        Library library = new Library();
        library.addBook(new Book("First name", "Author №1", "ISBN1", 2018));
        library.addBook(new Book("Second name", "Author №2", "ISBN2", 2016));

        ArrayList<Book> books = library.booksList();
        assertEquals(2, books.size());
    }

    @Test
    void testFindBookByTitle() {
        Library library = new Library();
        library.addBook(new Book("First name", "Author №1", "ISBN1", 2018));
        Book foundBook = library.findBookByTitle("First name");
        assertNotNull(foundBook);
        assertEquals("First name", foundBook.title);

        foundBook = library.findBookByTitle("Nonexistent name");
        assertNull(foundBook);
    }

    @Test
    void testRemoveBookByISBN() {
        Library library = new Library();
        library.addBook(new Book("First name", "Author №1", "ISBN1", 2018));
        assertTrue(library.removeBookByISBN("ISBN1"));
        assertFalse(library.removeBookByISBN("ISBN1"));
        assertFalse(library.removeBookByISBN("Nonexistent ISBN"));
    }
}
