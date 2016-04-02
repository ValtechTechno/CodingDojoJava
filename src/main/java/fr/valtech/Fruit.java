package fr.valtech;

public class Fruit {
    private int price;
    private int discountQuantity;
    private int discountAmount;

    public Fruit(int price) {
        this(price, 0, 0);
    }

    public Fruit(int price, int discountQuantity, int discountAmount) {
        this.price = price;
        this.discountQuantity = discountQuantity;
        this.discountAmount = discountAmount;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount(Integer fruitCount) {
        if(discountQuantity > 0){
            return fruitCount / discountQuantity * discountAmount;
        }
        return 0;
    }
}

