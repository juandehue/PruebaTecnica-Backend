package com.pruebaTecnica.api.mapper;

import com.pruebaTecnica.api.dto.ProductDTO;
import com.pruebaTecnica.api.dto.UpdateProductDTO;
import com.pruebaTecnica.api.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(ProductDTO dto) {
        ProductEntity p = new ProductEntity();
        p.setSku(dto.getSku());
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        p.setBrand(dto.getBrand());
        p.setDescription(dto.getDescription());
        return p;
    }

    public static void applyUpdates(ProductEntity p, UpdateProductDTO dto) {
        if (dto.getName() != null) p.setName(dto.getName());
        if (dto.getPrice() != null) p.setPrice(dto.getPrice());
        if (dto.getBrand() != null) p.setBrand(dto.getBrand());
        if (dto.getDescription() != null) p.setDescription(dto.getDescription());
    }
}
