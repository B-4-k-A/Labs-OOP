package src.Types;

import java.util.HashMap;

public class Shop extends Identification {
    private String adress;
    private HashMap<String, InfoOfProduct> prods = new HashMap<>();

    public Shop(String name, String adress) {
        super(name);
        this.adress = adress;
    }

    public String getAdress() {
        return this.adress;
    }

    public double getPrice(String prodId) {
        return tryGetInfoOfProd(prodId).getPrice();
    }

    public void changePrice(String prodId, double newPrice) {
        tryGetInfoOfProd(prodId).setPrice(newPrice);
    }

    public double getQuantity(String prodId) {
        return tryGetInfoOfProd(prodId).getQuantity();
    }

    public void changeQuantiy(String prodId, double quantity) {
        tryGetInfoOfProd(prodId).setQuantity(quantity);
    }

    public void addProduct(Product prod, double quantity, double price) {
        InfoOfProduct infoProd;
        if ((infoProd = prods.get(prod.getId())) == null)
            prods.put(prod.getId(), new InfoOfProduct(prod, quantity, price));
        else {
            infoProd.setQuantity(infoProd.getQuantity() + quantity);
            infoProd.setPrice(price);
        }
    }

    public void addProductWithCurPrice(String prodId, double quantity) {
        InfoOfProduct prod = tryGetInfoOfProd(prodId);
        prod.setQuantity(prod.getQuantity() + quantity);
    }

    public boolean isFind(String prodId) {
        return prods.containsKey(prodId);
    }

    public InfoOfProduct tryGetInfoOfProd(String prodId) {
        InfoOfProduct infoProd;
        if ((infoProd = prods.get(prodId)) == null) {
            throw new NullPointerException("Product with this " + prodId + " ID has not found in this shop");
        }
        return infoProd;
    }

    public InfoOfProduct getInfoOfProd(String prodId) {
        return prods.get(prodId);
    }

    public void showAllProd() {
        for (InfoOfProduct infoProd : prods.values()) {
            System.out
                    .println("\t" + infoProd.getName() + "\t" + infoProd.getQuantity() + "\t\t" + infoProd.getPrice());
        }
    }

    public void whatCanIBuy(double money) {
        if (prods.size() != 0) {
            for (InfoOfProduct infoProd : prods.values()) {
                System.out.println("\t\t" + infoProd.getName() + "\t" + (int) (money / infoProd.getPrice()));
            }
        } else {
            System.out.println("\t\t---");
        }
    }
}
