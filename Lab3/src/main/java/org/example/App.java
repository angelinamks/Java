package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Product product1 = new Product(1, "TV", 1000.0);
        Product product2 = new Product(2, "Notebook", 500.0);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        System.out.println("After adding products to cart: " + cart);

        cart.removeProduct(product2);
        System.out.println("After removing product2 from cart: " + cart);

        Order order = new Order(1, cart.getProducts(), "Processing");
        System.out.println("Order created: " + order);
    }
}
