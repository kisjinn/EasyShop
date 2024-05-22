package dev.sakshi.easyshop.services;

import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.dtos.SortParameter;
import dev.sakshi.easyshop.models.Product;
import dev.sakshi.easyshop.repositories.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
@Getter
public class SearchProductsService {
    private ProductRepository productRepository;
    public SearchProductsService(ProductRepository productRepository){
        this.productRepository= productRepository;
    }

 public Page<GenericProductDto> searchProduct(String query ,int pageNo, int sizeOfPage, List<SortParameter> sortByParameter){
//    //if 2 product have same title then by defaukt tiebreaker is product id
//     //we can have our own tiebreaker like price
//     //In API call, no need to configure sort by parameters like below
//     //we can configure it by using sortBy parametr from user
//        Sort sort= Sort.by("title").descending().and(
//                Sort.by("price").descending()
//        );

    Sort sort;
    if(sortByParameter.get(0).getSortType().equals("ASC")){
        sort= Sort.by(sortByParameter.get(0).getParameterName());
    }
    else{
        sort= Sort.by(sortByParameter.get(0).getParameterName()).descending();
    }
    for(int i=1;i< sortByParameter.size();i++){
        if(sortByParameter.get(i).getSortType().equals("ASC")){
            sort= sort.and(Sort.by(sortByParameter.get(i).getParameterName()));
        }
        else{
            sort= sort.and(Sort.by(sortByParameter.get(i).getParameterName()).descending());
        }
    }
    Page<Product> page= productRepository.findAllByTitleContaining(query, PageRequest.of(pageNo,sizeOfPage,sort));
     List<Product> productList= page.get().toList();
     List<GenericProductDto> genericProductDtoList= new ArrayList<>();
     for(Product product: productList){
         genericProductDtoList.add(GenericProductDto.covertToGenericProductDto(product));
     }

    Page<GenericProductDto> genericProductPage= new PageImpl<>(
            genericProductDtoList,
            page.getPageable(), page.getTotalElements());

     return genericProductPage;
 }

}
