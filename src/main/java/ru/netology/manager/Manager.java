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

    public Manager() {
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {                        //Поиск продукта по name
        Product[] result = new Product[0];                          //массив в котором будем возвращать найденные продукты
        int i = 0;
        Product[] tmp = new Product[repo.getAllProducts().length];  //массив куда будем помещать найденные элементы во время поиска по умолчанию считаем что подощли все товары

        for (Product product : repo.getAllProducts()) {             //Если в продукте книга
            if (product instanceof Book){
                Book book = (Book) product;
                if (book.matches(text)) {
                    tmp[i] = book;
                    i++;
                }
            }else if(product instanceof SmartPhone){                //Если в продукте смартфон
                SmartPhone phone = (SmartPhone) product;
                if (phone.matches(text)) {
                    tmp[i] = phone;
                    i++;
                }
            }else{
                if(product.matches(text)){                          //если в продукте продукт
                    tmp[i] = product;
                    i++;
                }
            }
        }

        if (i != 0) {
            result = new Product[i];
            System.arraycopy(tmp,0,result,0,i);
        }

        return result;
    }


}
