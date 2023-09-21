package ztgg.project.ecommerce.ecommerce.service;

import ztgg.project.ecommerce.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getItemByName(String name);

    List<Product> browseAllItems();

    List<Product> getItemsByPrice(double lowPrice, double highPrice);
}
