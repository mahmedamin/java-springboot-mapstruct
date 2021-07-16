package com.example.mapstruct.springmapstructdemo.modal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private int quantity;
    private long price;
    private String itemId;
    @OneToMany
    private List<Item> items;
}
