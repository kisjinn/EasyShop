package dev.sakshi.easyshop.services.FakeProduct;

import dev.sakshi.easyshop.ThirdPartyClient.FakeStoreProductServiceClient;
import dev.sakshi.easyshop.ThirdPartyClient.FakeStoreProductDto;
import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.models.Product;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductImplementation implements FakeProductService {
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
//    private RedisTemplate<String, Object> redisTemplate;
    FakeStoreProductImplementation(FakeStoreProductServiceClient fakeStoreProductServiceClient )
    //RedisTemplate<String, Object> redisTemplate
    {
        this.fakeStoreProductServiceClient =fakeStoreProductServiceClient;
//        this.redisTemplate= redisTemplate;
//        //key: string
//        //value: object
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
//        *********************Redis Implemntation******************************
     /* check if product already exist in cache
        if yes then fetch from cache and return as a response
        otherwise make an api call to fakestore and return result
      */
        //key: id and value: product details
//        GenericProductDto genericProductDto= (GenericProductDto) redisTemplate.opsForHash().get("PRODUCT", id);
//        if(genericProductDto!=null){
//            return genericProductDto;
//        }
//        else{
//            FakeStoreProductDto fakeStoreProductDto= fakeStoreProductServiceClient.getProductById(id);
//            genericProductDto= convertFaketoFenericProduct(fakeStoreProductDto);
//            //in redis, in PRODUCTS table for id 1, put genericproductdto
//            redisTemplate.opsForHash().put("PRODUCTS",id,genericProductDto);
//            return convertFaketoFenericProduct(fakeStoreProductDto);
//        }
//        ******************************************************
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
