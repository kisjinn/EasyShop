package dev.sakshi.easyshop.services.FakeProduct;

import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public interface FakeProductService {
GenericProductDto getProductById(Long id);
List<GenericProductDto> getProducts();
GenericProductDto createProduct(Product product);
GenericProductDto deleteProductById(Long id);
void updateById(Long id);
}
