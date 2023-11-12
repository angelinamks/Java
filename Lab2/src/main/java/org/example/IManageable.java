package org.example;
import java.util.List;

interface IManageable {
    void add(Item item);
    void remove(Item item);
    List<Item> listAvailableItems();
    List<Item> listBorrowedItems();
}

