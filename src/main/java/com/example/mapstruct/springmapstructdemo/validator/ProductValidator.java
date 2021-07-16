package com.example.mapstruct.springmapstructdemo.validator;

import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public int validate(int id) {
        if (id < 0)
            throw new ProductValidationException("Invalid id");
        return id;
    }
}
