package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] products = new Product[0];

    public void saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products,0,tmp,0,products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] getAllProducts() {
        Product[] result = new Product[products.length];
        System.arraycopy(products, 0, result, 0, products.length);
        return result;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != id) {
                tmp[copyToIndex] = products[i];
                copyToIndex++;
            }
        }
        products = new Product[tmp.length];
        System.arraycopy(tmp, 0, products, 0, tmp.length);
    }
}
