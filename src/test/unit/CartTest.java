package unit;

import isdwrk04.group5.iotbay.model.Cart;
import isdwrk04.group5.iotbay.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartTest {

    Cart cart;
    Product testProduct1;

    @BeforeEach
    public void beforeEach() {
        this.cart = new Cart();
        testProduct1 = new Product();
        testProduct1.setName("test1");
        testProduct1.setPrice(10.00);
    }

    @Test
    public void testAddItem() {
        cart.addItem(testProduct1);
        List<Product> products = cart.getProducts();
        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("test1", products.get(0).getName());
        Assertions.assertEquals(1, products.get(0).getQuantity());

        // Adding an item multiple times increases the quantity of that item instead of adding a duplicate
        cart.addItem(testProduct1);
        products = cart.getProducts();
        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals(2, products.get(0).getQuantity());
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(cart.isEmpty());
        cart.addItem(testProduct1);
        Assertions.assertFalse(cart.isEmpty());
    }

    @Test
    public void testClearCart() {
        cart.addItem(testProduct1);
        Assertions.assertEquals(1, cart.getProducts().size());

        cart.clearCart();
        Assertions.assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testUpdateQuantity() {
        cart.addItem(testProduct1);
        Assertions.assertEquals(1, cart.getProducts().get(0).getQuantity());

        cart.updateQuantity(0, 5);
        Assertions.assertEquals(5, cart.getProducts().get(0).getQuantity());
    }

    @Test
    public void testRemoveProduct() {
        cart.addItem(testProduct1);
        Assertions.assertEquals(1, cart.getProducts().size());

        cart.removeProduct(0);
        Assertions.assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testTotalPrice() {
        Assertions.assertEquals("0.00", cart.getTotalPrice());

        cart.addItem(testProduct1);
        Assertions.assertEquals("10.00", cart.getTotalPrice());

        cart.updateQuantity(0, 5);
        Assertions.assertEquals("50.00", cart.getTotalPrice());
    }
}
