package com.random.Spri.Service;

import com.random.Spri.Dto.ProductDto;
import com.random.Spri.Exception.ResourceNotFoundException;
import com.random.Spri.Mapper.ProductMapper;
import com.random.Spri.Model.Product;
import com.random.Spri.Model.User;
import com.random.Spri.Repository.ProductRepository;
import com.random.Spri.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);
        product.setCreatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }
    

    // Get a product by ID
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return ProductMapper.toDto(product);
    }

    //Get all product
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update a product
    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setUpdatedAt(LocalDateTime.now());

        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toDto(updatedProduct);
    }

    // Search products by name
    public List<ProductDto> searchProductsByName(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    // Delete a product
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductDto updateStockQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        int newQuantity = product.getStockQuantity() + quantity;
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }

        product.setStockQuantity(newQuantity);
        product.setUpdatedAt(LocalDateTime.now());

        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toDto(updatedProduct);
    }
}

