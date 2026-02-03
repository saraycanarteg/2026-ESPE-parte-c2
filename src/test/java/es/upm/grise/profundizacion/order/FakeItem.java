package es.upm.grise.profundizacion.order;

public class FakeItem implements Item {

    private Product product;
    private int quantity;
    private double price;

    public FakeItem(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int i) {
        this.quantity = i;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
