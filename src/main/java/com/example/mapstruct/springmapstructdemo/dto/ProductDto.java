package com.example.mapstruct.springmapstructdemo.dto;

import com.example.mapstruct.springmapstructdemo.modal.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class ProductDto {
    @Id
    private int id;
    private String name;
    private String description;
    private int quantity;
    private long price;
    private String itemId;
    private List<Item> itemsList;
}
