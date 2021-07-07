package com.example.mapstruct.springmapstructdemo.modal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String desc;
    private int quantity;
    private long price;
    private String itemId;
    @OneToMany
    private List<Item> items;
}
