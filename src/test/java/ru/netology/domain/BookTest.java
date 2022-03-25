package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldGetAuthor() {
        String expected = "Кинг";
        Book book = new Book(1,"Зеленая миля",400,"Кинг");
        String actual = book.getAuthor();
        assertEquals(actual,expected);
    }

    @Test
    void shouldSetAuthor() {
        String expected = "Кинг";
        Book book = new Book();
        book.setAuthor("Кинг");
        String actual = book.getAuthor();
        assertEquals(actual,expected);
    }
}