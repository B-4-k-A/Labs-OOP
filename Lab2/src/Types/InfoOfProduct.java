package src.Types;

public class InfoOfProduct {
    private String name;
    private double quantity;
    private double price;

    public InfoOfProduct() {}

    public InfoOfProduct(Product prod, double quantity, double price) {
        this.name = prod.getName();
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

}
