package com.me.sbb.rest.service;

import com.me.sbb.rest.entity.ProductEntity;
import com.me.sbb.rest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public ProductEntity createProduct(ProductEntity productEntity) {
    return this.productRepository.save(productEntity);
  }

}
