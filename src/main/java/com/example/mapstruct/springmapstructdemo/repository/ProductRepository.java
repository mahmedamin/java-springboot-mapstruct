package com.example.mapstruct.springmapstructdemo.repository;

import com.example.mapstruct.springmapstructdemo.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
