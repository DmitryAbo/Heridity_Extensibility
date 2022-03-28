package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldFindByName() {
        Product product = new Product(1, "Apple", 100_000);
        boolean actual = product.matches("Apple");
        assertTrue(actual);
    }

    @Test
    void shouldNoFindByName() {
        Product product = new Product(1, "Apple", 100_000);
        boolean actual = product.matches("Samsung");
        assertFalse(actual);
    }
}