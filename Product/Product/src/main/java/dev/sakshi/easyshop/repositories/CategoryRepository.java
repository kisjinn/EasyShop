package dev.sakshi.easyshop.repositories;

import dev.sakshi.easyshop.models.Category;
import dev.sakshi.easyshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(UUID uuid);

    @Override
    Category save(Category category);

    @Override
    void deleteById(UUID uuid);
}
