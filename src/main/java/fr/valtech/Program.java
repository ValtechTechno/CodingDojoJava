package fr.valtech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    /**
     * The main launcher of the application
     *
     * @param args
     */
    public static void main(String[] args) {

        FruitShop fruitShop = new FruitShop();
        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("# Type some fruit");
            while (true) {
                final String myFruit = entree.readLine();
                fruitShop.addFruit(myFruit);
                System.out.print(" > " + fruitShop.getTotal() + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
