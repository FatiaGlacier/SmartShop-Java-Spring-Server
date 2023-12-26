package com.fatianov.SmartShop.Models;

import com.fatianov.SmartShop.Entities.Product;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private Long id;

    private String name;

    private String manufacturer;

    private String description;

    private String type;

    private float priceUah;

    private int amount;

    private int weightGrams;

    private Date productionDate;

    private Date expirationDate;

    private boolean isPerishable;

    private byte[] image;

    private DiscountModel discount;

    public static ProductModel toModel(Product product) {
        ProductModel model = new ProductModel();
        model.id = product.getId();
        model.name = product.getName();
        model.manufacturer = product.getManufacturer();
        model.description = product.getDescription();
        model.type = product.getType();
        model.priceUah = product.getPriceUah();
        model.amount = product.getAmount();
        model.weightGrams = product.getWeightGrams();
        model.productionDate = product.getProductionDate();
        model.expirationDate = product.getExpirationDate();
        model.isPerishable = product.isPerishable();
        model.image = product.getImage();
        return model;
    }
}
