package fr.valtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class FruitShop {
    private Map<String, Integer> priceCatalog = new HashMap<String, Integer>();
    private Map<String, Discount> discountCatalog = new HashMap<String, Discount>();
    private List<String> fruits = new ArrayList<String>();

    public FruitShop() {
        this.priceCatalog.put("Pommes", 100);
        this.priceCatalog.put("Mele", 100);
        this.priceCatalog.put("Apples", 100);
        this.priceCatalog.put("Cerises", 75);
        this.priceCatalog.put("Bananes", 150);

        this.discountCatalog.put("Cerises", new Discount(2, 20));
        this.discountCatalog.put("Bananes", new Discount(2, this.priceCatalog.get("Bananes")));
        this.discountCatalog.put("Apples", new Discount(3, this.priceCatalog.get("Apples")));
        this.discountCatalog.put("Mele", new Discount(2, 50));
    }

    /**
     * Add a fruit to the cart
     */
    public void addFruit(String fruit) {
        this.fruits.add(fruit);
    }

    /**
     * The total fruit prices
     *
     * @return the total cart price
     */
    public int getTotal() {
        Map<String, Integer> fruitsGroupedByType = groupFruitsByType();

        int sum = 0;
        for (String fruit : fruitsGroupedByType.keySet()) {
            Integer fruitCount = fruitsGroupedByType.get(fruit);
            sum += fruitCount * this.priceCatalog.get(fruit);

            Discount discount = this.discountCatalog.get(fruit);
            if(discount != null){
                sum -= discount.eval(fruitCount);
            }
        }
        return sum;
    }

    private Map<String, Integer> groupFruitsByType() {
        Map<String, Integer> fruitsGroupedByType = new HashMap<String, Integer>();
        for (String fruit : fruits) {
            if (!fruitsGroupedByType.containsKey(fruit)) {
                fruitsGroupedByType.put(fruit, 0);
            }
            fruitsGroupedByType.put(fruit, fruitsGroupedByType.get(fruit) + 1);
        }
        return fruitsGroupedByType;
    }
}
