package com.fatianov.SmartShop.Models;

import com.fatianov.SmartShop.Entities.Item;
import com.fatianov.SmartShop.Entities.Order;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    private Long id;

    private String number;

    private String status;

    private Date creationDate;

    private Date receivedDate;

    private UserModel userModel;

    private Set<ItemModel> items;

    public static OrderModel toModel(Order order) {
        OrderModel model = new OrderModel();
        model.id = order.getId();
        model.number = order.getNumber();
        model.status = order.getStatus();
        model.creationDate = order.getCreationDate();
        model.receivedDate = order.getReceivedDate();
        model.userModel = UserModel.toModel(order.getUser());
        for(Item item: order.getItems()){
            model.items.add(ItemModel.toModel(item));
        }
        return model;
    }
}
