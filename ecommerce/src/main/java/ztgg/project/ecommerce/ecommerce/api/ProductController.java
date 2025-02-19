package ztgg.project.ecommerce.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ztgg.project.ecommerce.ecommerce.model.Product;
import ztgg.project.ecommerce.ecommerce.service.ProductService;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/n/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/item")
    public Map<String, Object> getItemByName(@RequestParam(value = "name") String name) throws JsonProcessingException {
        List<Product> items = productService.getItemByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", 1);
        result.put("data", objectMapper.writeValueAsString(items));
        return result;
    }

    @RequestMapping("browseAll")
    public Map<String, Object> browseAllItems() throws JsonProcessingException {
        List<Product> items = productService.browseAllItems();
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", 1);
        result.put("data", objectMapper.writeValueAsString(items));
        return result;
    }

    @RequestMapping("itemsByPrice")
    public Map<String, Object> getItemsByPrice(@RequestParam(value = "lowPrice") double lowPrice,
                                               @RequestParam(value = "highPrice") double highPrice) throws JsonProcessingException {
        List<Product> items = productService.getItemsByPrice(lowPrice, highPrice);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", 1);
        result.put("data", objectMapper.writeValueAsString(items));
        return result;
    }
}
