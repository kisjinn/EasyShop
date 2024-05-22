package dev.sakshi.easyshop.repositories;
import dev.sakshi.easyshop.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

//    List<Product> findAll(Pageable pageable);
    List<Product> findAll();

    @Override
    Optional<Product> findById(UUID uuid);

    @Override
    Product save(Product product);

    @Override
    void deleteById(UUID uuid);

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);

}
