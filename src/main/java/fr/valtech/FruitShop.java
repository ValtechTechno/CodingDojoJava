package fr.valtech;

public class FruitShop {

    private int total = 0;

    /**
     * Add a fruit to the cart
     */
    public void addFruit(String fruit){
        if(fruit.equals("Pommes")){
            total += 100;
        }
        //TODO add some code here
    }

    /**
     * The total fruit prices
     * @return the total cart price
     */
    public int getTotal(){
        return total;
    }
}