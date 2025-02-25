package com.me.sbb.rest.service;

import com.me.sbb.rest.dao.ProductDao;
import com.me.sbb.rest.data.ProductDto;
import com.me.sbb.rest.data.ProductEntity;
import com.me.sbb.rest.repository.ProductRepository;
import com.me.sbb.utils.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductDao productDao;

  public ProductEntity getProduct(String id) {
    return this.productDao.getProduct(id);
  }

  public ProductEntity saveProduct(
          String productId, String productName,
          int productPrice, int productStock, LocalDateTime dateTime) {

    ProductEntity productEntity = getProductEntity(
            productId, productName, productPrice, productStock, dateTime);
    this.productDao.saveProduct(productEntity);

    return productEntity;
  }
  public List<ProductEntity> getProductList() {
    return productDao.getProductList();
  }

  private ProductEntity getProductEntity(
          String productId, String productName,
          Integer productPrice, Integer productStock, LocalDateTime dateTime){
    return new ProductEntity(
            productId, productName, productPrice, productStock, dateTime
    );
  }
}
