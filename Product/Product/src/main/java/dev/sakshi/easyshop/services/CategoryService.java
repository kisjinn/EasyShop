package dev.sakshi.easyshop.services;

import dev.sakshi.easyshop.models.Category;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.repositories.CategoryRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryService(CategoryRepository categoryRepository){
         this.categoryRepository= categoryRepository;
    }

    public Category getCategoryById(String uuid) {
        Optional<Category> optionalCategory=categoryRepository.findById(UUID.fromString(uuid));
        return optionalCategory.orElse(null);
    }

    public List<Category> getCategories() {
        List<Category> ans= categoryRepository.findAll();
        return ans;
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public String deleteCategoryById(String id) {
        categoryRepository.deleteById(UUID.fromString(id));
        return "Deleted SuccessFully";
    }

    public void updateById(String id){
        Optional<Category> p= categoryRepository.findById(UUID.fromString(id));
        if(p.isPresent()) {
            categoryRepository.save(p.get());
        }
    }
}
