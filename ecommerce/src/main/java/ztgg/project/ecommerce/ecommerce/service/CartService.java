package ztgg.project.ecommerce.ecommerce.service;

import ztgg.project.ecommerce.ecommerce.model.Cart;

public interface CartService {
    boolean addItemToCart(int id, int count);

    Cart displayCart();
}
