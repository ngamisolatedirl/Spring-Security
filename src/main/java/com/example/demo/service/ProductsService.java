package com.example.demo.service;

import com.example.demo.entity.Products;
import com.example.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository PR;
    public List<Products> getAllProducts() {return PR.findAll();}
    public void addProduct(Products products) {PR.save(products);}
    public void deleteProduct(Products products) {PR.delete(products);}
    public Optional<Products> getProductById(Long id) {return PR.findById(id);}
}
