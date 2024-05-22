package dev.sakshi.easyshop.controllers;

import dev.sakshi.easyshop.Exception.NotFoundException;
import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.security.JWTObj;
import dev.sakshi.easyshop.security.TokenValidator;
import dev.sakshi.easyshop.services.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@RequestMapping("/products")
@RestController
public class ProductController {
    ProductService productService;
    TokenValidator tokenValidator;
    public ProductController(ProductService productService, TokenValidator tokenValidator){
        this.productService = productService;
        this.tokenValidator= tokenValidator;
    }
    //Implementing paging on this
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        List<GenericProductDto> genericProductDtos= productService.getProducts();
        return genericProductDtos;
    }
    @GetMapping("/{uuid}")
    public Product getProductById (@Nullable @RequestHeader (HttpHeaders.AUTHORIZATION) String token, @PathVariable("uuid") String uuid) throws NotFoundException {
        Optional<JWTObj> optionalJWTObj;
        JWTObj tokenObj = null;
        //validate token
        if(token!=null){
            optionalJWTObj = tokenValidator.validateToken(token);
            if(optionalJWTObj.isEmpty()){
                return null;
            }
            tokenObj= optionalJWTObj.get();
        }
        Long userIdAceessing = tokenObj.getUserId();
        return productService.getProductById(uuid, userIdAceessing);
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
