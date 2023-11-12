package org.example;

class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            System.out.println("Book borrowed: " + this.title);
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (this.isBorrowed) {
            this.isBorrowed = false;
            System.out.println("Book returned: " + this.title);
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}