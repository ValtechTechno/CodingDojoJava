package fr.valtech;

class Discount {
    private int fruitCount;
    private int discount;

    Discount(int fruitCount, int discount) {
        this.fruitCount = fruitCount;
        this.discount = discount;
    }

    int eval(int fruitCountToEval) {
        return fruitCountToEval / fruitCount * discount;
    }
}
