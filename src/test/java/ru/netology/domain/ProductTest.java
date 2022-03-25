package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldGetId() {
        int expected = 1;
        Product product = new Product(1, "Мороженое", 50);
        int actual = product.getId();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetId() {
        int expected = 1;
        Product product = new Product();
        product.setId(1);
        int actual = product.getId();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetName() {
        String expected = "Молоко";
        Product product = new Product(1, "Молоко", 50);
        String actual = product.getName();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetName() {
        String expected = "Молоко";
        Product product = new Product();
        product.setName("Молоко");
        String actual = product.getName();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetPrice() {
        int expected = 50;
        Product product = new Product(1, "Мороженое", 50);
        int actual = product.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetPrice() {
        int expected = 50;
        Product product = new Product();
        product.setPrice(50);
        int actual = product.getPrice();
        assertEquals(expected, actual);
    }
}