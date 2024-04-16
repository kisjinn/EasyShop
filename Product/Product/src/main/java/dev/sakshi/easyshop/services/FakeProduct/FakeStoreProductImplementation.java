package dev.sakshi.easyshop.services.FakeProduct;

import dev.sakshi.easyshop.ThirdPartyClient.FakeStoreProductServiceClient;
import dev.sakshi.easyshop.ThirdPartyClient.FakeStoreProductDto;
import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductImplementation implements FakeProductService {
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    FakeStoreProductImplementation(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient =fakeStoreProductServiceClient;
    }
    GenericProductDto convertFaketoFenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto= new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreProductServiceClient.getProductById(id);
        return convertFaketoFenericProduct(fakeStoreProductDto);
    }

    @Override
    public List<GenericProductDto> getProducts() {
        List<GenericProductDto> ans= new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getProducts()){
            ans.add(convertFaketoFenericProduct(fakeStoreProductDto));
        }
        return ans;
    }

    @Override
    public GenericProductDto createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreProductServiceClient.createProduct(product);
        return convertFaketoFenericProduct(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreProductServiceClient.deleteProductById(id);
        return convertFaketoFenericProduct(fakeStoreProductDto);

    }

    public void updateById(Long id){



    }
}
