package com.fatianov.SmartShop.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Items")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "full_price",
            scale = 2)
    private float fullPrice;

    @Column(name = "discounted_price",
            scale = 2)
    private float discountPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
