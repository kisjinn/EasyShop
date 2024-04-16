package dev.sakshi.easyshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="categories")
public class Category extends Base {

    String name;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;


    // Constructor accepting name
    public Category(String name) {
        this.name = name;
    }
}
