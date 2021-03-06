package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product prod1 = new Product(1, "Молоко", 65);
    Product prod2 = new Book(2, "О дивный новый мир", 500, "Хаскли");
    Product prod3 = new SmartPhone(3, "Apple", 100_000, "Китай");
    Product prod4 = new Book(4, "Молоко как смысл жизни", 100, "Богомолов");
    Repository repo = new Repository();

    @Test
    void shouldSaveOneProduct() {
        Product[] expected = new Product[]{prod1};
        repo.saveProduct(prod1);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveSameProduct() {
        Product[] expected = new Product[]{prod1, prod2};
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmpty() {
        Product[] expected = new Product[0];
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveOneProductLastAdded() {
        Product[] expected = new Product[]{prod1, prod2};
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.removeById(3);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveOneProductNoLastAdded() {
        Product[] expected = new Product[]{prod1, prod3};
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.removeById(2);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveOnlyProduct() {
        Product[] expected = new Product[0];
        repo.saveProduct(prod1);
        repo.removeById(1);
        Product[] actual = repo.getAllProducts();
        assertArrayEquals(expected, actual);
    }

}