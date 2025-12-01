package com.pruebaTecnica.api.service;


import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.ProductEntity;

public interface ProductService {

    ProductEntity create(ProductDTO dto);

    ProductEntity update(Long id, Long userId, UpdateProductDTO dto);

    boolean delete(Long id, Long userId);

    ProductEntity get(Long id);
}
