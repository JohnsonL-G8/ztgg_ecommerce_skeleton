package ztgg.project.ecommerce.ecommerce.impl;

import ztgg.project.ecommerce.ecommerce.model.Product;
import ztgg.project.ecommerce.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    public static List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getItemByName(String name) {
        List<Product> result = products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Product> browseAllItems() {
        return products;
    }

    @Override
    public List<Product> getItemsByPrice(double lowPrice, double highPrice) {
        List<Product> result = products.stream()
                .filter(product -> product.getPrice() >= lowPrice && product.getPrice() <= highPrice)
                .collect(Collectors.toList());
        return result;
    }
}
