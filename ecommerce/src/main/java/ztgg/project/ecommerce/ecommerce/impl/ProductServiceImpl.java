package ztgg.project.ecommerce.ecommerce.impl;

import org.springframework.stereotype.Service;
import ztgg.project.ecommerce.ecommerce.model.Product;
import ztgg.project.ecommerce.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    @Override
    public Product getItemById(int id) {
        List<Product> result = products.stream()
                .filter(product -> product.getId() == id)
                .collect(Collectors.toList());
        return result.size() == 0 ? null : result.get(0);
    }
}
