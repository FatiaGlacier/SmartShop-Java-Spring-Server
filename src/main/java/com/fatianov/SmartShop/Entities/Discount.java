package com.fatianov.SmartShop.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Discounts")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "percent")
    private int percent;

    @Column(name = "end_date")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
