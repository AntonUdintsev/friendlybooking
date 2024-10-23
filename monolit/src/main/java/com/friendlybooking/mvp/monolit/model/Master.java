package com.friendlybooking.mvp.monolit.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "master")
    private List<Operation> services;

    @OneToMany(mappedBy = "master")
    private List<Timetable> schedules;
}