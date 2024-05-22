package dev.sakshi.easyshop.services;
import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.repositories.ProductRepository;
import dev.sakshi.easyshop.security.JWTObj;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    ProductRepository productRepository;
    ProductService(ProductRepository productRepository){
        this.productRepository= productRepository;
    }
    public Product getProductById(String uuid, Long userIdAceessing) {
        /*
        Note: we will store user id who created that product along with product in Product table
        If Product is private i.e created by admin
        then userTrying to access will be able to access only if userIdAceessing== user_id_who_created_thatProduct
         Product product= productRepository.findById(UUID.fromString(uuid));
        if(produvt.getStatus.equals(PRIVATE)){
               if(! produtct.getCreatedById.equals(userIdAceessing)){
                         return null;
               }
        }
        Note: ProductService can also cache the token so that it doesn't have to hit userService everytime to validate token
        */

       Optional<Product> optionalProduct=productRepository.findById(UUID.fromString(uuid));
        return optionalProduct.orElse(null);
    }

    //Implement pagination
    public List<GenericProductDto> getProducts() {
//        List<Product> products= productRepository.findAll(
//                Pageable.ofSize(10) //get frst 10 products
//        );
//
//        PageRequest pageRequest= PageRequest.of(2,10);
        List<Product> products1= productRepository.findAll();


        List<GenericProductDto> genericProductDtos= new ArrayList<>();
        for(Product p: products1){
            genericProductDtos.add(new GenericProductDto().covertToGenericProductDto(p));
        }
        return genericProductDtos;

    }

    public String createProduct(Product product) {
        productRepository.save(product);
        return "saved successfully";
    }

    public String deleteProductById(String id) {
        productRepository.deleteById(UUID.fromString(id));
        return "Deleted SuccessFully";
    }

    public void updateById(String id){
        Optional<Product> p= productRepository.findById(UUID.fromString(id));
        if(p.isPresent()) {
            productRepository.save(p.get());
        }
    }
}
