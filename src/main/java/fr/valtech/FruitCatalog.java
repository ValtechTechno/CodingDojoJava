package fr.valtech;

public class FruitCatalog {
    public final static Fruit POMMES = new Fruit(100);
    public final static Fruit MELE = new Fruit(100, 2, 100);
    public final static Fruit APPLES = new Fruit(100, 3, 100);
    public final static Fruit CERISES = new Fruit(75, 2, 20);
    public final static Fruit BANANES = new Fruit(150, 2, 150);

    public static Fruit getFruitByName(String fruitName) {
        if (fruitName.equals("Pommes")) {
            return POMMES;
        }
        else if (fruitName.equals("Mele")) {
            return MELE;
        }
        else if (fruitName.equals("Apples")) {
            return APPLES;
        }
        else if (fruitName.equals("Cerises")) {
            return CERISES;
        }
        else if (fruitName.equals("Bananes")) {
            return BANANES;
        }
        else {
            return null;
        }
    }
}
