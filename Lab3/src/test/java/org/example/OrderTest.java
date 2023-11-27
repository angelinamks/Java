package org.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class OrderTest {

    private Product mockProduct;
    private Cart mockCart;
    private Order order;

    @BeforeEach
    public void setUp() {
        mockProduct = Mockito.mock(Product.class);
        mockCart = Mockito.mock(Cart.class);
        when(mockCart.getProducts()).thenReturn(Arrays.asList(mockProduct));

        order = new Order(1, mockCart.getProducts(), "Processing");
    }

    @Test
    public void testOrderStatus() {
        assertEquals("Processing", order.getStatus());
    }

    @Test
    public void testOrderProducts() {
        List<Product> products = order.getProducts();
        assertTrue(products.contains(mockProduct));
        assertEquals(1, products.size());
    }
}
