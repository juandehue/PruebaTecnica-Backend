package com.pruebaTecnica.api.repository;

import com.pruebaTecnica.api.entity.LogProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogProductRepository extends JpaRepository<LogProductEntity, Long> {
    
}
