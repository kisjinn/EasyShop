package dev.sakshi.easyshop.controllers;

import dev.sakshi.easyshop.dtos.GenericProductDto;
import dev.sakshi.easyshop.dtos.SearchRequestDto;
import dev.sakshi.easyshop.services.SearchProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
public class searchController {
    SearchProductsService searchProductsService;
    public  searchController(SearchProductsService searchProductsService){
        this.searchProductsService = searchProductsService;
    }
    @PostMapping("/")
    public Page<GenericProductDto> search(@RequestBody SearchRequestDto searchRequestDto){
    return searchProductsService.searchProduct(
            searchRequestDto.getQuery(),
            searchRequestDto.getPageNo(),
            searchRequestDto.getSizeOfPage(),
            searchRequestDto.getSortBy()
          );
    }

}
