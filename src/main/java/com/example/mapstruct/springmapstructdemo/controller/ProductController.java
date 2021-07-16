package com.example.mapstruct.springmapstructdemo.controller;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.mapper.ProductMapper;
import com.example.mapstruct.springmapstructdemo.modal.Product;
import com.example.mapstruct.springmapstructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductDto>> index() {
        return new ResponseEntity<>(
                productMapper.modelsToDtos(productRepository.findAll()), HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> find(@PathVariable Integer id) {
        return new ResponseEntity<ProductDto>(
                productMapper.modelToDto(productRepository.findById(id).get()), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
        Product product = productRepository.save(productMapper.dtoToModel(productDto));
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    @GetMapping("test")
//    public String testMe() {
//        String a = "foo";
//        String b = "bar";
//        String c = "hola";
//        String d = "mundo";
//
////        StringBuilder s = new StringBuilder();
////        s.append("s");
//        return a.concat(" : ").concat(b).concat(" : ").concat(c).concat(" : ").concat(d);
//    }
}
