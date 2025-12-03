package com.pruebaTecnica.api.service;


import java.util.List;

import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.LogProductEntity;
import com.pruebaTecnica.api.entity.ProductEntity;
import com.pruebaTecnica.api.repository.LogProductRepository;

public interface ProductService {

    ProductEntity create(ProductDTO dto);

    ProductEntity update(Long id, Long userId, UpdateProductDTO dto);

    boolean delete(Long id, Long userId);

    ProductEntity get(Long id);

    List<ProductEntity> getAll();

    List<LogProductEntity> getAllLogs();

}
