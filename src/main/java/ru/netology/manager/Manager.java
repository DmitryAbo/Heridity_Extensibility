package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Manager() {
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {                        //Поиск продукта по name
        Product[] result = new Product[0];                          //массив в котором будем возвращать найденные продукты
        for (Product product : repo.getAllProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = new Product[tmp.length];
                System.arraycopy(tmp, 0, result, 0, tmp.length);
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


}
