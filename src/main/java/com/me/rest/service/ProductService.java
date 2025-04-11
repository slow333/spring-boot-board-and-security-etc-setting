package com.me.rest.service;

import com.me.rest.dao.ProductDao;
import com.me.rest.data.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
