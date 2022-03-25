package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Product prod1 = new Product(12, "Молоко", 65);
    Product prod2 = new Book(13, "О дивный новый мир", 500, "Хаскли");
    Product prod3 = new SmartPhone(14, "Apple", 100_000, "Китай");
    Product prod4 = new Book(15, "Молоко как смысл жизни", 100, "Богомолов");
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    @Test
    void shouldAddOneProduct() {
        Product[] expected = new Product[]{prod1};
        manager.add(prod1);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddSameProductDifferentClasses() {
        Product[] expected = new Product[]{prod1, prod2, prod3};
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneProductBySearch() {
        Product[] expected = new Product[]{prod1};
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        Product[] actual = manager.searchBy("Молоко");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindSameProductBySearchDifferentClasses() {
        Product[] expected = new Product[]{prod1, prod4};
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);
        Product[] actual = manager.searchBy("Молоко");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNoResultsBySearch() {
        Product[] expected = new Product[0];
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);
        Product[] actual = manager.searchBy("Эвкалипт");
        assertArrayEquals(expected, actual);
    }


}