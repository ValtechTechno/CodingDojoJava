package fr.valtech;

import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private Map<String, Integer> catalog = new HashMap<String, Integer>();
    private int total;

    public FruitShop(){
        this.catalog.put("Pommes", 100);
        this.catalog.put("Cerises", 75);
        this.catalog.put("Bananes", 150);
    }

    /**
     * Add a fruit to the cart
     */
    public void addFruit(String fruit) {
        if(catalog.containsKey(fruit)){
            this.total += this.catalog.get(fruit);
        }
    }

    /**
     * The total fruit prices
     *
     * @return the total cart price
     */
    public int getTotal() {
        return this.total;
    }
}
