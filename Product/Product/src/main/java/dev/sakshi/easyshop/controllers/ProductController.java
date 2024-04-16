package dev.sakshi.easyshop.controllers;

import dev.sakshi.easyshop.Exception.NotFoundException;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.services.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Primary
@RequestMapping("products")
@RestController
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{uuid}")
    public Product getProductById (@PathVariable("uuid") String uuid) throws NotFoundException {
        return productService.getProductById(uuid);
    }
    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
       return productService.createProduct(product);
    }
    @DeleteMapping ("/{uuid}")
    public String deleteProductById(@PathVariable("uuid") String uuid){
        return productService.deleteProductById(uuid);

    }
    @PutMapping("/{uuid}")
    public void updateById(@PathVariable("uuid") String uuid){

    }
}
