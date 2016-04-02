package fr.valtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class FruitShop {
    private Map<String, Integer> catalog = new HashMap<String, Integer>();
    private List<String> fruits = new ArrayList<String>();

    public FruitShop() {
        this.catalog.put("Pommes", 100);
        this.catalog.put("Cerises", 75);
        this.catalog.put("Bananes", 150);
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
        for (String key : fruitsGroupedByType.keySet()) {
            Integer fruitCount = fruitsGroupedByType.get(key);
            if (this.catalog.containsKey(key)) {
                sum += fruitCount * this.catalog.get(key);
            }
            if (key.equals("Cerises")) {
                sum -= fruitCount / 2 * 20;
            }
        }
        return sum;
    }

    private Map<String, Integer> groupFruitsByType() {
        Map<String, Integer> fruitsGroupedByType = new HashMap<String, Integer>();
        for(String fruit : fruits){
            if(!fruitsGroupedByType.containsKey(fruit)){
                fruitsGroupedByType.put(fruit, 0);
            }
            fruitsGroupedByType.put(fruit, fruitsGroupedByType.get(fruit) + 1);
        }
        return fruitsGroupedByType;
    }
}
