package ztgg.project.ecommerce.ecommerce.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ztgg.project.ecommerce.ecommerce.service.CartService;

import java.util.HashMap;

@RestController("rest/n/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("addItem")
    public HashMap<String, Object> addItemToCart(@JsonProperty(value = "id") String id) {
        cartService.addItemToCart(id);
        return new HashMap<>();
    }

    @RequestMapping("display")
    public HashMap<String, Object> displayCart() {
        cartService.displayCart();
        return new HashMap<>();
    }
}
