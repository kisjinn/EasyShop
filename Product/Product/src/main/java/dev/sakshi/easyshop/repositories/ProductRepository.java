package dev.sakshi.easyshop.repositories;

import dev.sakshi.easyshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(UUID uuid);

    @Override
    Product save(Product product);

    @Override
    void deleteById(UUID uuid);
}
