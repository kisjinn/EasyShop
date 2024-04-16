package dev.sakshi.easyshop.controllers;

import dev.sakshi.easyshop.Exception.NotFoundException;
import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.services.FakeProduct.FakeProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class FakeProductController {
    FakeProductService fakeProductService;
    //there is nonly one class of type ProductService so Spring contianer make obj of FakeStoreProductImp class and inject it here
    //dependency injection using constructor
    public FakeProductController(FakeProductService fakeProductService){
        this.fakeProductService = fakeProductService;
    }
    @GetMapping("/")
    public List<GenericProductDto> getAllProducts(){
     return fakeProductService.getProducts();
    }
    @GetMapping("{id}")
    public GenericProductDto getProductById (@PathVariable Long id) throws NotFoundException{
      return fakeProductService.getProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody Product product){
         return fakeProductService.createProduct(product);
    }
    @DeleteMapping ("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable Long id){
        ResponseEntity<GenericProductDto> response= new ResponseEntity<>(fakeProductService.deleteProductById(id),
                                                    HttpStatus.OK);
       return response;

    }
    @PutMapping("{id}")
    public void updateById(@PathVariable Long id){

        }






}
