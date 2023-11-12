package org.example;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();


        Book book1 = new Book("A Tale of Two Cities", "1234id", "Charles Dickens");
        DVD dvd1 = new DVD("Pirates of the Caribbean: The Curse of the Black Pearl ", "12id2434", 1000);



        library.add(book1);
        library.add(dvd1);


        Patron patron1 = new Patron("John Doe", "P1111P");
        library.registerPatron(patron1);

        System.out.println("\nTrying to borrow an already borrowed book:");
        library.lendItem(patron1, book1);


        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "id23434", "J. K. Rowling");


        System.out.println("\nTrying to borrow a book not in the library:");
        library.lendItem(patron1, book2);

        System.out.println("Lending items...");
        library.lendItem(patron1, book1);
        library.lendItem(patron1, dvd1);

        System.out.println("\nBorrowed items:");
        for (Item item : library.listBorrowedItems()) {
            System.out.println(item.getTitle());
        }

        System.out.println("\nReturning items...");
        library.returnItem(patron1, book1);
        library.returnItem(patron1, dvd1);

        System.out.println("\nAvailable items after return:");
        for (Item item : library.listAvailableItems()) {
            System.out.println(item.getTitle());
        }
    }
}
