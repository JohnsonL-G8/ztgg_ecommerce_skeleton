package ztgg.project.ecommerce.ecommerce.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Cart {
    private List<CartItem> itemList;
}
