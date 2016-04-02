package fr.valtech;

import java.util.HashMap;
import java.util.Map;

class FruitShop {
    private Map<Fruit, Integer> fruits;

    public FruitShop() {
        fruits = new HashMap<>();
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
        String[] fruits = inputFruit.split(",");
        for (String fruitName : fruits) {
            Fruit fruit = FruitCatalog.getFruitByName(fruitName.trim());
            if (fruit != null) {
                this.fruits.merge(fruit, 1, Integer::sum);
            }
        }
    }

    /**
     * The total fruit prices
     *
     * @return the total cart price
     */
    public int getTotal() {
        return fruitsPrice() - globalDiscountOnAppleFruits() - globalDiscount();
    }

    private int fruitsPrice() {
        return this.fruits
                .entrySet()
                .stream()
                .map(this::getSetPrice)
                .mapToInt(fruitPrice -> fruitPrice)
                .sum();
    }

    private int getSetPrice(Map.Entry<Fruit, Integer> entrySet) {
        Fruit fruit = entrySet.getKey();
        int fruitCount = entrySet.getValue();
        return fruit.getPriceForASet(fruitCount);
    }

    private int globalDiscountOnAppleFruits() {
        int fruitCountOfAppleType =
                this.fruits.get(FruitCatalog.POMMES) +
                this.fruits.get(FruitCatalog.MELE) +
                this.fruits.get(FruitCatalog.APPLES);

        return fruitCountOfAppleType / 4 * 100;
    }

    private int globalDiscount() {
        int totalFruitCount = this.fruits
                .values()
                .stream()
                .mapToInt(x->x).sum();

        return totalFruitCount / 5 * 200;
    }
}
