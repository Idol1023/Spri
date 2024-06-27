package com.random.Spri.Repository;

import com.random.Spri.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query()
    List<Product> findByNameContainingIgnoreCase(String name);
}
