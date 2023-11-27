package org.example;
import java.util.List;
public class Order {
    private int id;
    private List<Product> products;
    private String status;

    public Order(int id, List<Product> products, String status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public int getId() { return id; }
    public List<Product> getProducts() { return products; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", products=" + products + ", status='" + status + "'}";
    }
}
