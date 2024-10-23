package com.friendlybooking.mvp.monolit.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Master master;

    @ManyToOne
    private Operation operation;

    private LocalDateTime bookingTime;
    private String status;
}