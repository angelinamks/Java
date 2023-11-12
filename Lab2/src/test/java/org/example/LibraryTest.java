package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Patron patron;
    private Book book;
    private DVD dvd;

    @BeforeEach
    void setUp() {
        library = new Library();
        patron = new Patron("John Doe", "P001");
        book = new Book("Test Book", "B001", "Test Author");
        dvd = new DVD("Test DVD", "D001", 120);

        library.add(book);
        library.add(dvd);
        library.registerPatron(patron);
    }

    @Test
    void borrowAndReturnBook() {
        library.lendItem(patron, book);
        assertTrue(book.isBorrowed());
        assertNotNull(patron.getBorrowedItems().contains(book));

        library.returnItem(patron, book);
        assertFalse(book.isBorrowed());
        assertFalse(patron.getBorrowedItems().contains(book));
    }

    @Test
    void listAvailableAndBorrowedItems() {
        library.lendItem(patron, book);

        List<Item> availableItems = library.listAvailableItems();
        assertFalse(availableItems.contains(book));
        assertTrue(availableItems.contains(dvd));

        List<Item> borrowedItems = library.listBorrowedItems();
        assertTrue(borrowedItems.contains(book));
        assertFalse(borrowedItems.contains(dvd));
    }

    @Test
    void attemptToBorrowUnavailableItem() {
        library.lendItem(patron, book);
        Patron anotherPatron = new Patron("Jane Doe", "P002");

        library.registerPatron(anotherPatron);
        library.lendItem(anotherPatron, book);

        assertFalse(anotherPatron.getBorrowedItems().contains(book));
    }

    @Test
    void lendItemNotInLibrary() {
        Book nonExistentBook = new Book("Non Existent", "B003", "Unknown");
        library.lendItem(patron, nonExistentBook);

        assertFalse(patron.getBorrowedItems().contains(nonExistentBook));
    }
}


