package org.example;
import java.util.ArrayList;
import java.util.List;

class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (items.contains(item)) {
            if (!item.isBorrowed() && patrons.contains(patron)) {
                patron.borrow(item);
            } else {
                System.out.println("Item is already borrowed: " + item.getTitle());
            }
        } else {
            System.out.println("Item not found in library: " + item.getTitle());
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (items.contains(item)) {
            if (item.isBorrowed() && patrons.contains(patron)) {
                patron.returnItem(item);
            } else {
                System.out.println("Item was not borrowed: " + item.getTitle());
            }
        } else {
            System.out.println("Item not found in library: " + item.getTitle());
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public List<Item> listAvailableItems() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public List<Item> listBorrowedItems() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Item item : items) {
            if (item.isBorrowed()) {
                borrowedItems.add(item);
            }
        }
        return borrowedItems;
    }
}
