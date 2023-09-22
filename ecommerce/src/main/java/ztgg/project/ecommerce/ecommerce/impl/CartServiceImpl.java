package ztgg.project.ecommerce.ecommerce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ztgg.project.ecommerce.ecommerce.model.Cart;
import ztgg.project.ecommerce.ecommerce.model.CartItem;
import ztgg.project.ecommerce.ecommerce.service.CartService;
import ztgg.project.ecommerce.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    public static Cart cart = Cart.builder()
            .itemList(new ArrayList<>()).build();

    @Autowired
    private ProductService productService;
    @Override
    public boolean addItemToCart(int id, int count) {
        if (productService.getItemById(id) == null) {
            return false;
        }
        List<CartItem> cartItems = cart.getItemList();
        boolean inCart = false;
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId() == id) {
                cartItem.setCount(cartItem.getCount() + count);
                inCart = true;
                break;
            }
        }
        if (!inCart) {
            cartItems.add(CartItem.builder()
                    .id(id).count(count)
                    .build());
        }
        cart.setItemList(cartItems);
        return true;
    }

    @Override
    public Cart displayCart() {
        return cart;
    }
}
