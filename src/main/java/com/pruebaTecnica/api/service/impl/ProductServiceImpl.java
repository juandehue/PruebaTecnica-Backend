package com.pruebaTecnica.api.service.impl;

import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.LogProductEntity;
import com.pruebaTecnica.api.entity.ProductEntity;
import com.pruebaTecnica.api.mapper.ProductMapper;
import com.pruebaTecnica.api.repository.LogProductRepository;
import com.pruebaTecnica.api.repository.ProductRepository;
import com.pruebaTecnica.api.service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final LogProductRepository logRepository;

    @Override
    public ProductEntity create(ProductDTO dto) {
        ProductEntity entity = ProductMapper.toEntity(dto);
        ProductEntity saved = productRepository.save(entity);

        return saved;
    }

    @Override
    public ProductEntity update(Long id, Long userId, UpdateProductDTO dto) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product == null) return null;

        String oldValue = product.toString();

        ProductMapper.applyUpdates(product, dto);

        ProductEntity updated = productRepository.save(product);

        // Log UPDATE
        LogProductEntity log = new LogProductEntity();
        log.setAction("UPDATE");
        log.setProductId(id);
        log.setUserId(userId);
        log.setOldValue(oldValue);
        log.setNewValue(updated.toString());
        log.setCreatedAt(LocalDateTime.now());
        logRepository.save(log);

        return updated;
    }

    @Override
    public boolean delete(Long id, Long userId) {

        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product == null) return false;

        // Log DELETE primero
        LogProductEntity log = new LogProductEntity();
        log.setAction("DELETE");
        log.setProductId(id);
        log.setUserId(userId);
        log.setOldValue(product.toString());
        log.setNewValue(null);
        log.setCreatedAt(LocalDateTime.now());
        logRepository.save(log);

        // Ahora sí elimina
        productRepository.delete(product);

        return true;
    }

    @Override
    public ProductEntity get(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
