package com.me.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.rest.data.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
