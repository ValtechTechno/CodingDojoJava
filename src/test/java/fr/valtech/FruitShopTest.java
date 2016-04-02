package fr.valtech;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitShopTest {
    private FruitShop _fruitShop;

    @Before
    public void Initialize() {
        _fruitShop = new FruitShop();
    }

    @Test
    public void should_have_total_to_100_when_adding_Pommes_once() {
        // When
        _fruitShop.addFruit("Pommes");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(100);
    }

    @Test
    public void should_have_total_to_175_when_adding_Cerises_once() {
        // When
        _fruitShop.addFruit("Cerises");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(75);
    }

    @Test
    public void should_have_total_to_175_when_adding_Bananes_once() {
        // When
        _fruitShop.addFruit("Bananes");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(150);
    }

    @Test
    public void should_apply_discount_when_adding_Cerises_twice() {
        // When
        _fruitShop.addFruit("Cerises");
        _fruitShop.addFruit("Cerises");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(150 - 20);
    }

    @Test
    public void should_apply_discount_when_adding_Cerises_twice_with_Pommes_on_the_middle() {
        // When
        _fruitShop.addFruit("Cerises");
        _fruitShop.addFruit("Pommes");
        _fruitShop.addFruit("Cerises");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(100 + 150 - 20);
    }

    @Test
    public void should_apply_discount_when_adding_Bananes_twice() {
        // When
        _fruitShop.addFruit("Bananes");
        _fruitShop.addFruit("Bananes");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(150);
    }

    @Test
    public void should_calculate_price_of_Mele() {
        // When
        _fruitShop.addFruit("Mele");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(100);
    }

    @Test
    public void should_calculate_price_of_Apples() {
        // When
        _fruitShop.addFruit("Apples");

        // Then
        assertThat(_fruitShop.getTotal()).isEqualTo(100);
    }
}