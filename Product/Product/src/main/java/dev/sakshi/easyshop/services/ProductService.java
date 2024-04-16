package dev.sakshi.easyshop.services;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    ProductRepository productRepository;
    ProductService(ProductRepository productRepository){
        this.productRepository= productRepository;
    }
    public Product getProductById(String uuid) {
       Optional<Product> optionalProduct=productRepository.findById(UUID.fromString(uuid));
        return optionalProduct.orElse(null);
    }

    public List<Product> getProducts() {
        List<Product> ans= productRepository.findAll();
        return ans;
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
