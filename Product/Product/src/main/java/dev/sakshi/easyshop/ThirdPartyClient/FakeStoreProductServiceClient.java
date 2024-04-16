package dev.sakshi.easyshop.ThirdPartyClient;

import dev.sakshi.easyshop.Exception.NotFoundException;
import dev.sakshi.easyshop.models.Product;
import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
//this class is wrapper over fakke store API
//this class wont be knowing generic product dto
//this class should retiurn fakestoreproductDto as it is
public class FakeStoreProductServiceClient{
    private RestTemplateBuilder restTemplateBuilder;
    private String withIdRequestUrl= "https://fakestoreapi.com/products/{id}";
    private String withoutIdRequestUrl="https://fakestoreapi.com/products";

    public FakeStoreProductServiceClient (RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder= restTemplateBuilder;
    }
    //A spring's Displatcher, which uses the Jackson JSON processing library to process the incoming data.(from object to json). It uses internally a library called jackson


    public FakeStoreProductDto getProductById(Long id) {
        RestTemplate restTemplate= restTemplateBuilder.build();  //restTemplate is a library used to send http request
        //pass url from whicch we will get o/p and a class having attribute as same as incoming o/p
        //incoming req will have datatype of  FakeStoreProductDto.class
        //pass variable of requestUrl as well
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(withIdRequestUrl, FakeStoreProductDto.class, id);
        response.getStatusCode();
        //create getter setter in FakeStoreProductDro as all attributes are private
        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        if(fakeStoreProductDto==null){
            new NotFoundException("Product with given id doesn't exist");
        }
        //otherwise return product
        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getProducts() {
        RestTemplate restTemplate= restTemplateBuilder.build();
        //bracuse of eraser, List<FakeStoreProductDto> wont work as at runtime, Eraser removes datatype of list
        // and java does not know about dataype of list
        //so solution is instead of using arraylist(collection), use array
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(withoutIdRequestUrl , FakeStoreProductDto[].class);
        List<FakeStoreProductDto> ans= new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: response.getBody()){
            ans.add(fakeStoreProductDto);
        }
        return ans;
    }


    public FakeStoreProductDto createProduct(Product product) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.postForEntity(withIdRequestUrl,product, FakeStoreProductDto.class);
        response.getStatusCode();
        //create getter setter in FakeStoreProductDro as all attributes are private
        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate= restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(withIdRequestUrl, HttpMethod.DELETE,
                requestCallback, responseExtractor, id);

        response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        return fakeStoreProductDto;

    }

    public void updateById(Long id){



    }
}
