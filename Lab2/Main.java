import java.util.HashMap;

import src.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> prods = new HashMap<>();
        HashMap<String, String> shops = new HashMap<>();
        var manag = new ShopManager();

        prods.put("milk", manag.addNewProduct("Milk"));
        prods.put("coca-cola", manag.addNewProduct("Coca-Cola"));
        prods.put("bread", manag.addNewProduct("Bread"));
        prods.put("rice", manag.addNewProduct("Rise"));

        shops.put("okey", manag.addNewShop("okey", "Doctor sreet"));
        shops.put("diksi", manag.addNewShop("diksi", "Kamenaostrovskiy street"));
        shops.put("pyaterochka", manag.addNewShop("pyaterochka", "chkalovskiy street"));

        manag.addProdToShop(shops.get("okey"), prods.get("milk"), 5, 25);
        manag.addProdToShop(shops.get("okey"), prods.get("coca-cola"), 15, 15);
        manag.addProdToShop(shops.get("okey"), prods.get("bread"), 20, 10);


        manag.addProdToShop(shops.get("pyaterochka"), prods.get("milk"), 10, 25);
        manag.addProdToShop(shops.get("pyaterochka"), prods.get("coca-cola"), 9, 15);
        manag.addProdToShop(shops.get("pyaterochka"), prods.get("rice"), 9, 15);

        manag.addProdToShop(shops.get("diksi"), prods.get("milk"), 10, 25.75);
        manag.addProdToShop(shops.get("diksi"), prods.get("coca-cola"), 11, 18);
        manag.addProdToShop(shops.get("diksi"), prods.get("rice"), 11, 22);

        manag.addProdToShopWithCurPrice(shops.get("okey"), prods.get("milk"), 10);
        manag.showAllProdInShop(shops.get("okey"));

        System.out.println("Pruduct in all shops:");
        manag.showAllProdInAllShops();

        System.out.println("Product in shop:");
        manag.showAllProdInShop(shops.get("okey"));

        System.out.println("Find a shop where some product cheapest:");
        manag.findShopWithCheapProd(prods.get("milk"));

        System.out.println("What can i buy for 100$:");
        manag.whatCanBuy(100);

        System.out.println("Amount of some product:");
        double amount = manag.amountSomeProdToBuyInShop(shops.get("okey"), prods.get("milk"), 30);
        System.out.println(amount);

        System.out.println("Find a shop with cheapest order:");
        HashMap<String, Double> order = new HashMap<>();
        order.put(prods.get("milk"), 10d);
        order.put(prods.get("coca-cola"), 10d);

        manag.findShopWithCheapOrder(order);
    }
}