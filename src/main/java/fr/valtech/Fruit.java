package fr.valtech;

class Fruit {
    private int price;
    private int discountQuantity;
    private int discountAmount;

    Fruit(int price) {
        this(price, 0, 0);
    }

    Fruit(int price, int discountQuantity, int discountAmount) {
        this.price = price;
        this.discountQuantity = discountQuantity;
        this.discountAmount = discountAmount;
    }

    public int getPriceForASet(Integer fruitCount) {
        return fruitCount * price - discountFor(fruitCount);
    }

    private int discountFor(Integer fruitCount) {
        if (discountQuantity > 0) {
            return fruitCount / discountQuantity * discountAmount;
        }
        return 0;
    }
}

