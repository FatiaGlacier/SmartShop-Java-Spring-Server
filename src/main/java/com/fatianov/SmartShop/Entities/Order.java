package com.fatianov.SmartShop.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number",
            length = 8)
    private String number;

    @Column(name = "status")
    private String status;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "received_date")
    private Date receivedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<Item> items;
}
