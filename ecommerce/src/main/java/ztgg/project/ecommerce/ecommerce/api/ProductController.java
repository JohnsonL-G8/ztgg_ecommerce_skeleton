package ztgg.project.ecommerce.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ztgg.project.ecommerce.ecommerce.service.ProductService;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

@RestController("/rest/n/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/item")
    public Map<String, Object> getItemByName(@JsonProperty(value = "name") String name) {
        productService.getItemByName(name);
        return new HashMap<>();
    }

    @RequestMapping("/browse")
    public Map<String, Object> browseAllItems() {
        productService.browseAllItems();
        return new HashMap<>();
    }

    @RequestMapping("/itemsByPrice")
    public Map<String, Object> getItemsByPrice() {
        productService.getItemsByPrice();
        return new HashMap<>();
    }
}
