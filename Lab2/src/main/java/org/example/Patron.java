package org.example;
import java.util.ArrayList;
import java.util.List;

class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        if (!item.isBorrowed()) {
            item.borrowItem();
            borrowedItems.add(item);
        } else {
            System.out.println("Item is already borrowed.");
        }
    }

    public void returnItem(Item item) {
        if (item.isBorrowed()) {
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("Item was not borrowed.");
        }
    }
}

