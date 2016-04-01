package fr.valtech;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FruitShop {

    /**
     * Add a fruit to the cart
     */
    public void addFruit(String fruit){
        //TODO add some code here
    }

    /**
     * The total fruit prices
     * @return the total cart price
     */
    public int getTotal(){
        return 0;
    }


    /**
     * The main launcher of the application
     * @param args
     */
    public static void main ( String[] args) {

        FruitShop fruitShop = new FruitShop();
        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (true){

                final String myFruit = entree.readLine();

                //Todo add some code here

                System.out.print(" > "+ myFruit + "\n");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: "+e.getMessage());
        }
    }
}
