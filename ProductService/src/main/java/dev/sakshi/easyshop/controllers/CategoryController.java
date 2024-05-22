package dev.sakshi.easyshop.controllers;

import dev.sakshi.easyshop.Exception.NotFoundException;
import dev.sakshi.easyshop.models.Category;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService categortService;
    CategoryController(CategoryService categoryService){
        this.categortService= categoryService;
    }
    @GetMapping("/")
    public List<Category> getAllCategory(){
        return categortService.getCategories();
    }
    @GetMapping("/{uuid}")
    public Category getProductById (@PathVariable("uuid") String uuid) throws NotFoundException {
        return categortService.getCategoryById(uuid);
    }
    @PostMapping("/create")
    public void createCategory(@RequestBody Category category){
        categortService.createCategory(category);
    }
    @DeleteMapping("/{uuid}")
    public String deleteCategoryById(@PathVariable("uuid") String uuid){
        return categortService.deleteCategoryById(uuid);

    }
    @PutMapping("/{uuid}")
    public void updateById(@PathVariable("uuid") String uuid){

    }

}
