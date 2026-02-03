package es.upm.grise.profundizacion.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderTest {

    private Product createProduct(long id) {
        Product p = new Product();
        p.setId(id);
        return p;
    }

    @Test
    void testAddItemCorrectly() {

        Order order = new Order();
        Product p = createProduct(1);

        Item item = new FakeItem(p, 2, 10);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void testIncreaseQuantityIfSameProductAndPrice() {

        Order order = new Order();
        Product p = createProduct(1);

        order.addItem(new FakeItem(p, 2, 10));
        order.addItem(new FakeItem(p, 3, 10));

        Item stored = order.getItems().iterator().next();

        assertEquals(5, stored.getQuantity());
    }

    @Test
    void testAddNewItemIfSameProductDifferentPrice() {

        Order order = new Order();
        Product p = createProduct(1);

        order.addItem(new FakeItem(p, 2, 10));
        order.addItem(new FakeItem(p, 2, 15));

        assertEquals(2, order.getItems().size());
    }

    @Test
    void testNegativePriceThrowsException() {

        Order order = new Order();
        Product p = createProduct(1);

        Item item = new FakeItem(p, 2, -5);

        assertThrows(IncorrectItemException.class,
                () -> order.addItem(item));
    }

    @Test
    void testZeroQuantityThrowsException() {

        Order order = new Order();
        Product p = createProduct(1);

        Item item = new FakeItem(p, 0, 10);

        assertThrows(IncorrectItemException.class,
                () -> order.addItem(item));
    }
}

