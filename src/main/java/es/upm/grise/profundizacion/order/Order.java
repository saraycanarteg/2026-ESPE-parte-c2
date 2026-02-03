package es.upm.grise.profundizacion.order;

import java.util.ArrayList;
import java.util.Collection;

public class Order {

    private Collection<Item> items;

    /*
     * Constructor
     */
    public Order() {
        items = new ArrayList<>(); // Vacía pero no nula
    }

    /*
     * Method to code / test
     */
    public void addItem(Item item) {

        if (item.getPrice() < 0) {
            throw new IncorrectItemException("Negative price");
        }

        if (item.getQuantity() <= 0) {
            throw new IncorrectItemException("Quantity must be > 0");
        }

        for (Item existingItem : items) {

            // mismo producto
            if (existingItem.getProduct().getId() ==
                item.getProduct().getId()) {

                // mismo precio → sumar cantidad
                if (existingItem.getPrice() == item.getPrice()) {

                    existingItem.setQuantity(
                            existingItem.getQuantity() + item.getQuantity()
                    );
                    return;
                }
            }
        }

        // agregar nuevo item
        items.add(item);
    }

    /*
     * Getters
     */
    public Collection<Item> getItems() {
        return this.items;
    }
}


