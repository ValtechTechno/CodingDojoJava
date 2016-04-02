package fr.valtech;

import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private Map<Fruit, Integer> fruits = new HashMap<Fruit, Integer>();

    public FruitShop() {
        fruits.put(FruitCatalog.APPLES, 0);
        fruits.put(FruitCatalog.BANANES, 0);
        fruits.put(FruitCatalog.CERISES, 0);
        fruits.put(FruitCatalog.MELE, 0);
        fruits.put(FruitCatalog.POMMES, 0);
    }

    /**
     * Add a fruit to the cart
     */
    public void addFruit(String inputFruit) {
        String[] fruits = inputFruit.split(", ?");
        for (String fruitName : fruits) {
            Fruit fruit = FruitCatalog.getFruitByName(fruitName);
            if (fruit != null) {
                this.fruits.put(fruit, this.fruits.get(fruit) + 1);
            }
        }
    }

    /**
     * The total fruit prices
     *
     * @return the total cart price
     */
    public int getTotal() {
        int total = getPriceByFruitGroups();
        total -= getAppleFruitCount() / 4 * 100;
        total -= getTotalFruits() / 5 * 200;
        return total;
    }

    private int getPriceByFruitGroups() {
        int byFruitGroupPrice = 0;
        for (Fruit fruit : this.fruits.keySet()) {
            Integer fruitCount = this.fruits.get(fruit);
            byFruitGroupPrice += fruitCount * fruit.getPrice();
            byFruitGroupPrice -= fruit.getDiscount(fruitCount);
        }
        return byFruitGroupPrice;
    }

    private int getTotalFruits() {
        int count = 0;
        for (int fruitCount : this.fruits.values()) {
            count += fruitCount;
        }
        return count;
    }

    private int getAppleFruitCount() {
        return this.fruits.get(FruitCatalog.POMMES) +
                this.fruits.get(FruitCatalog.MELE) +
                this.fruits.get(FruitCatalog.APPLES);
    }
}
