package dev.sakshi.easyshop.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;


@Getter
@Setter
@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Base{
   private String title;
   private String description;
   private String image;
   @ManyToOne(cascade ={CascadeType.PERSIST})
   private Category category;

   private double price;

}
