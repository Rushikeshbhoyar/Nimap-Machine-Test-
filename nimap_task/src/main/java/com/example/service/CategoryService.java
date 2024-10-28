package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Catagory;
import com.example.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
        public Page<Catagory> getAllCategories(int page, int size) {
      Pageable pageable = PageRequest.of(page, size);
        return categoryRepository.findAll(pageable);
    }

    public Catagory getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Catagory createCategory(Catagory catagory) {
        return categoryRepository.save(catagory);
    }

    public Catagory updateCategory(Long id, Catagory catagory) {
        Catagory existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(catagory.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

