package com.fatianov.SmartShop.Models;

import com.fatianov.SmartShop.Entities.Discount;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiscountModel {

    private Long id;

    private int percent;

    private Date endDate;

    public static DiscountModel toModel(Discount discount){
        DiscountModel model = new DiscountModel();
        model.id = discount.getId();
        model.percent = discount.getPercent();
        model.endDate = discount.getEndDate();
        return model;
    }
}
