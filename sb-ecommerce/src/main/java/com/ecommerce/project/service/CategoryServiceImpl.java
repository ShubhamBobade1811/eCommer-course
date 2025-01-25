package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

//    private List<Category> categories = new ArrayList<>();
//    private long nextId = 1L;
//
//    @Override
//    public List<Category> getAllCategories() {
//        return categories;
//    }
//
//    @Override
//    public String createCategory(Category category) {
//        category.setCategoryId(nextId++);
//        categories.add(category);
//        return "New category successfully created";
//    }
//
//    @Override
//    public String deleteCategory(Long categoryId) {
//        Category category = categories.stream()
//                .filter(a -> a.getCategoryId().equals(categoryId))
//                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
//
//        categories.remove(category);
//        return "Category deleted successfully";
//    }
//
//    @Override
//    public Category updateCategory(Category category, Long categoryId) {
//        Optional<Category> category1 = categories.stream()
//                .filter(f -> f.getCategoryId().equals(categoryId))
//                .findFirst();
//
//
//        if (category1.isPresent()) {
//            Category existingCategory = category1.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            return existingCategory;
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
//        }


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new APIException("No categories created yet");
        }
        return categories;
    }

    @Override
    public Category createCategory(Category category) {
        Category byCategoryName = categoryRepository.findByCategoryName(category.getCategoryName());
        if(byCategoryName != null) {
            throw new APIException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            categoryRepository.delete(category.get());
            return "Category deleted successfully";
        }else{
            throw new ResourceNotFoundException("Category", "id", categoryId);
        }

    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);
        if(existingCategory.isPresent()){
            Category category1 = existingCategory.get();
            category1.setCategoryName(category.getCategoryName());
            categoryRepository.save(category1);
            return category1;
        }else{
            throw new ResourceNotFoundException("Category", "id", categoryId);
        }

    }
}
