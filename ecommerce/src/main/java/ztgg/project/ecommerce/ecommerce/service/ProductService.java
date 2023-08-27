package ztgg.project.ecommerce.ecommerce.service;

public interface ProductService {
    void getItemByName(String name);

    void browseAllItems();

    void getItemsByPrice();
}
