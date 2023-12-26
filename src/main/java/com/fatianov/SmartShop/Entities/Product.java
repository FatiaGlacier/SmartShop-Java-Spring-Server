package com.fatianov.SmartShop.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "priceUah",
            scale = 2)
    private float priceUah;

    @Column(name = "amount")
    private int amount;

    @Column(name = "weightGrams")
    private int weightGrams;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "is_perishable")
    @ColumnTransformer(read = "case when is_perishable = 1 then true else false end", write = "case when ? then 1 else 0 end")
    private boolean isPerishable;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @OneToMany(mappedBy = "product")
    private Set<Item> items;

    @OneToOne(mappedBy = "product")
    private Discount discount;
}
