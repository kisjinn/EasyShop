package dev.sakshi.easyshop.dtos;

import dev.sakshi.easyshop.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    //public class GenericProductDto implements Serializable{  => for using redis
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public static  GenericProductDto covertToGenericProductDto(Product p){
        GenericProductDto genericProductDto= new GenericProductDto();
        genericProductDto.setCategory(p.getCategory().getName());
        genericProductDto.setDescription(p.getDescription());
        genericProductDto.setPrice(p.getPrice());
        genericProductDto.setImage(p.getImage());
        genericProductDto.setTitle(p.getTitle());
        return genericProductDto;
}
}