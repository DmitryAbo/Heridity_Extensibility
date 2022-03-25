package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    @Test
    void shouldGetManufacturer() {
        String expexted = "China";
        SmartPhone phone = new SmartPhone(1,"Apple",100_000,"China");
        String actual = phone.getManufacturer();
        assertEquals(actual,expexted);
    }

    @Test
    void shouldSetManufacturer() {
        String expexted = "China";
        SmartPhone phone = new SmartPhone();
        phone.setManufacturer("China");
        String actual = phone.getManufacturer();
        assertEquals(actual,expexted);
    }
}