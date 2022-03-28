package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldFindByAuthor() {
        Product book = new Book(1, "О дивный новый мир", 500, "Хаскли");
        boolean actual = book.matches("Хаскли");
        assertTrue(actual);
    }

    @Test
    void shouldFindByName() {
        Product book = new Book(1, "О дивный новый мир", 500, "Хаскли");
        boolean actual = book.matches("О дивный новый мир");
        assertTrue(actual);
    }

    @Test
    void shouldNoFindByAuthor() {
        Product book = new Book(1, "О дивный новый мир", 500, "Хаскли");
        boolean actual = book.matches("Не найдешь");
        assertFalse(actual);
    }
}