package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.Repository;
import ru.netology.domain.Book;

public class Manager {
    private Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {                        //Поиск продукта по name
        Product[] result = new Product[0];                          //массив в котором будем возвращать найденные продукты

        for (Product product : repo.getAllProducts()) {             //Если в продукте книга
            if (product instanceof Book) {
                Book book = (Book) product;
                if (book.matches(text)) {
                    Product[] tmp = new Product[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = book;
                    result = new Product[tmp.length];
                    System.arraycopy(tmp, 0, result, 0, tmp.length);
                }
            } else if (product instanceof SmartPhone) {                //Если в продукте смартфон
                SmartPhone phone = (SmartPhone) product;
                if (phone.matches(text)) {
                    Product[] tmp = new Product[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = phone;
                    result = new Product[tmp.length];
                    System.arraycopy(tmp, 0, result, 0, tmp.length);
                }
            } else {
                if (product.matches(text)) {                          //если в продукте продукт
                    Product[] tmp = new Product[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = product;
                    result = new Product[tmp.length];
                    System.arraycopy(tmp, 0, result, 0, tmp.length);
                }
            }
        }
        return result;
    }


}
