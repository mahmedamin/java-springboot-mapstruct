package com.example.mapstruct.springmapstructdemo.mapper;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.modal.Product;
import com.example.mapstruct.springmapstructdemo.validator.ProductValidationException;
import com.example.mapstruct.springmapstructdemo.validator.ProductValidator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(uses = {ProductValidator.class}, componentModel = "spring", imports = UUID.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

//    @Mapping(source = "product.desc", target = "description", defaultValue = "No Description")
//    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
//    @Mapping(source = "product.items", target = "itemsList")
    ProductDto modelToDto(Product product) throws ProductValidationException;

    List<ProductDto> modelsToDtos(List<Product> product) throws ProductValidationException;

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto) throws ProductValidationException;
}
