package ztgg.project.ecommerce.ecommerce.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int id;

    private String name;

    private String category;

    private double price;

    private String description;
}
