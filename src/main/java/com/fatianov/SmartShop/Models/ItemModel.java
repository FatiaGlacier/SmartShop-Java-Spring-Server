package com.fatianov.SmartShop.Models;

import com.fatianov.SmartShop.Entities.Item;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    private Long id;

    private ProductModel product;

    private Integer quantity;

    private float fullPrice;

    private float discountPrice;

    public static ItemModel toModel(Item item) {
        ItemModel model = new ItemModel();
        model.id = item.getId();
        model.product = ProductModel.toModel(item.getProduct());
        model.quantity = item.getQuantity();
        model.fullPrice = item.getFullPrice();
        model.discountPrice = item.getDiscountPrice();
        return model;
    }
}
