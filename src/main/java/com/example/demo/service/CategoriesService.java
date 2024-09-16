package com.example.demo.service;

import com.example.demo.entity.Categories;
import com.example.demo.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public void addCategory(Categories category) {
        categoriesRepository.save(category);
    }

    public void removeCategory(Categories category) {
        categoriesRepository.delete(category);
    }

    public Optional<Categories> getCategoryById(int id) {
        return categoriesRepository.findById(id);
    }
}
