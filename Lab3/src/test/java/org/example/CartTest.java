package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import java.util.List;

public class CartTest {
    private Cart cart;
    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        mockProduct = Mockito.mock(Product.class);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(mockProduct);
        assertTrue(cart.getProducts().contains(mockProduct));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(mockProduct);
        cart.removeProduct(mockProduct);
        assertFalse(cart.getProducts().contains(mockProduct));
    }

    @Test
    public void testGetProductsReturnsCopy() {
        cart.addProduct(mockProduct);

        List<Product> productsFromCart = cart.getProducts();
        productsFromCart.remove(mockProduct);

        assertTrue(cart.getProducts().contains(mockProduct));
    }

}