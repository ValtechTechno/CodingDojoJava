package fr.valtech;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitShopTest {

    @Test
    public void should_return_one_apple_price(){
        //Given
        FruitShop fruitShop = new FruitShop();

        //When
        fruitShop.addFruit("pommes");

        //Then
        assertThat(fruitShop.getTotal()).isEqualTo(100);
    }
}
