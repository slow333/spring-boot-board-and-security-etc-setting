package com.me.sbb.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.sbb.rest.data.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
