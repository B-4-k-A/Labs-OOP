package src;

import java.util.ArrayList;
import java.util.HashMap;

import src.Types.*;

public class ShopManager {
    private HashMap<String, Product> products = new HashMap<>();
    private HashMap<String, Shop> shops = new HashMap<>();

    public ShopManager() {
    }

    public String addNewShop(String name, String address) {
        Shop shop = new Shop(name, address);
        shops.put(shop.getId(), shop);
        return shop.getId();
    }

    public String addNewProduct(String name) {
        Product prod = new Product(name);
        products.put(prod.getId(), prod);
        return prod.getId();
    }

    public void addProdToShop(String shopId, String prodId, double quantity, double price) {
        tryGetShop(shopId).addProduct(tryGetProduct(prodId), quantity, price);
    }

    public void addProdToShopWithCurPrice(String shopId, String prodId, double quantity) {
        tryGetShop(shopId).addProductWithCurPrice(prodId, quantity);
    }

    public void findShopWithCheapProd(String prodId) {
        double minPrice = -1;
        boolean firstTime = true;
        ArrayList<String> shopNames = new ArrayList<>();
        InfoOfProduct infoProd = new InfoOfProduct();
        for (Shop shop : shops.values()) {
            if (shop.isFind(prodId)) {
                infoProd = shop.getInfoOfProd(prodId);
                if (minPrice > infoProd.getPrice() | firstTime) {
                    minPrice = infoProd.getPrice();
                    shopNames.clear();
                    shopNames.add(shop.getName());
                    firstTime = false;
                } else if (minPrice == infoProd.getPrice()) {
                    shopNames.add(shop.getName());
                }
            }
        }
        System.out.println(infoProd.getName() + " cheapest in:");
        System.out.println("\tShop\tPrice");
        for (String shopName : shopNames) {
            System.out.println("\t" + shopName + "\t" + minPrice);
        }
    }
    
    public void showAllProdInAllShops() {
        for (String shopId : shops.keySet()) {
            showAllProdInShop(shopId);
        }
    }

    public void showAllProdInShop(String shopId) {
        Shop shop = tryGetShop(shopId);
        System.out.println(shop.getName());
        System.out.println("\tName\tQuantity\tPrice");
        shop.showAllProd();
    }

    public void whatCanBuy(double money) {
        System.out.println("You can buy in:");
        for (Shop shop : shops.values()) {
            System.out.println("\t" + shop.getName());
            System.out.println("\t\tName\tQuantity");
            shop.whatCanIBuy(money);
        }
    }

    public double amountSomeProdToBuyInShop(String shopId, String prodId, double quantity) {
        InfoOfProduct infoProd = tryGetShop(shopId).tryGetInfoOfProd(prodId);
        if (quantity <= infoProd.getQuantity()) {
            return infoProd.getQuantity() * quantity;
        }
        return -1d;
    }

    public void findShopWithCheapOrder(HashMap<String, Double> order) {
        ArrayList<String> shopWithChepOrder = new ArrayList<>();
        double minAmount = 0d;
        for (Shop shop : shops.values()) {
            double amount = 0d;
            int count = order.size();
            for (String orderProdId : order.keySet()) {
                    if (shop.isFind(orderProdId)) {
                        InfoOfProduct infoProd = shop.getInfoOfProd(orderProdId);
                        if (infoProd.getQuantity() >= order.get(orderProdId)) {
                            count--;
                        }
                    }
            }
            if(count != 0) {
                continue;
            } else {
                for (String orderProdId : order.keySet()) {
                            amount += order.get(orderProdId) * shop.getInfoOfProd(orderProdId).getPrice();
                }
                if(minAmount == 0 || minAmount > amount) {
                    minAmount = amount;
                    shopWithChepOrder.clear();
                    shopWithChepOrder.add(shop.getName());
                } else if(minAmount == amount) {
                    shopWithChepOrder.add(shop.getName());
                }
            }
        }
        if (shopWithChepOrder.size() == 0) {
            System.out.println("There are not shop with this product or quantity of product");
        } else {
            System.out.println("Shop with cheapest order amount is:");
            for (String shopName : shopWithChepOrder) {
                System.out.println("\t" + shopName + "\t" + minAmount);
            }
        }

    }

    protected Shop tryGetShop(String shopId) {
        Shop shop = shops.get(shopId);
        if (shop == null) {
            throw new NullPointerException("Shop with" + shopId + "ID not found");
        }
        return shop;
    }

    protected Product tryGetProduct(String prodId) {
        Product prod = products.get(prodId);
        if (prod == null) {
            throw new NullPointerException("Product with" + prodId + "Id not found");
        }
        return prod;
    }

}
