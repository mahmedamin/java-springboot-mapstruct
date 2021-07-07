package com.example.mapstruct.springmapstructdemo.modal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Item {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Product product;
}
