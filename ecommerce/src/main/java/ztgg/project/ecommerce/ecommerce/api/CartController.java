package ztgg.project.ecommerce.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ztgg.project.ecommerce.ecommerce.model.Cart;
import ztgg.project.ecommerce.ecommerce.service.CartService;

import java.util.HashMap;

@RestController
@RequestMapping("/rest/n/cart")
public class CartController {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private CartService cartService;

    @RequestMapping("addItem")
    public HashMap<String, Object> addItemToCart(@RequestParam(value = "id") int id,
                                                 @RequestParam(value = "count") int count) {
        HashMap<String, Object> result = new HashMap<>();
        boolean data = cartService.addItemToCart(id, count);
        result.put("result", 1);
        result.put("data", data);
        return result;
    }

    @RequestMapping("display")
    public HashMap<String, Object> displayCart() {
        HashMap<String, Object> result = new HashMap<>();
        Cart data = cartService.displayCart();
        result.put("result", 1);
        result.put("data", data);
        return result;
    }
}
