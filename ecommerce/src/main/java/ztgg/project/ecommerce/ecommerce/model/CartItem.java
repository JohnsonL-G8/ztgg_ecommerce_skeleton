package ztgg.project.ecommerce.ecommerce.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartItem {
    private int id;

    private int count;
}
