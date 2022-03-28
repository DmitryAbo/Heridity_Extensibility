package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    @Test
    void shouldFindByManufacturer() {
        Product phone = new SmartPhone(1, "Apple", 100_000, "Китай");
        boolean actual = phone.matches("Китай");
        assertTrue(actual);
    }

    @Test
    void shouldFindByName() {
        Product phone = new SmartPhone(1, "Apple", 100_000, "Китай");
        boolean actual = phone.matches("Apple");
        assertTrue(actual);
    }

    @Test
    void shouldNoFindByManufacturer() {
        Product phone = new SmartPhone(1, "Apple", 100_000, "Китай");
        boolean actual = phone.matches("Не найдешь");
        assertFalse(actual);
    }
}