package com.example.mapstruct.springmapstructdemo.mapper;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.modal.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring ", imports = UUID.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.desc", target = "description", defaultValue = "No Description")
    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "product.items", target = "itemsList")
    ProductDto modelToDto(Product product);

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto);
}
