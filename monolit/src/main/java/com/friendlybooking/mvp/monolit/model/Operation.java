package com.friendlybooking.mvp.monolit.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Integer duration; // длительность в минутах

    @ManyToOne
    private Master master;
}