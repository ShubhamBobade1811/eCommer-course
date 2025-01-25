package com.ecommerce.project.controller;


import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getALlCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }


    @PostMapping("api/public/categories")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        Category category1 = categoryService.createCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }


    @DeleteMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
            String s = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "api/admin/categories/{categoryId}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
            Category updatedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }


}
