  package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Catagory;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {	
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Catagory> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return categoryService.getAllCategories(page, size);
    }

    @GetMapping("/{id}")
    public Catagory getCategoryById(@PathVariable Long id) {
    	System.out.println("Userid >>> "+id);
        return categoryService.getCategoryById(id);
    }

    @PostMapping()
    public Catagory createCategory(@RequestBody Catagory catagory) {
    	System.out.println("category >>> "+catagory.getName());
    return categoryService.createCategory(catagory);
    }
    @PutMapping("/{id}")
    public Catagory updateCategory(@PathVariable Long id, @RequestBody Catagory catagory) {
      return categoryService.updateCategory(id, catagory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}



