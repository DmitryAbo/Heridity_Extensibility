package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldGetAuthor() {
        String expected = "Кинг";
        Book book = new Book(1, "Зеленая миля", 400, "Кинг");
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetAuthor() {
        String expected = "Кинг";
        Book book = new Book();
        book.setAuthor("Кинг");
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }
}