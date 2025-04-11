//package com.me.sbb.rest.service;
//
//import com.me.sbb.rest.data.ProductDto;
//import com.me.sbb.rest.entity.ProductEntity;
//import com.me.sbb.rest.repository.ProductRepository;
//import com.me.sbb.utils.DataNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class ProductService2 {
//
//  private final ProductRepository productRepository;
//
//  public ProductDto getProduct(String id) {
//    Optional<ProductEntity> productEntity = this.productRepository.findById(id);
//    if (productEntity.isEmpty()) {
//      throw new DataNotFoundException("제품이 없어요");
//    }
//    ProductEntity product = productEntity.get();
//    return new ProductDto(
//            product.getProductId(),product.getProductName(),
//            product.getProductPrice(),product.getProductStock()
//    );
//  }
//
//  public ProductDto saveProduct(
//          String productId, String productName,
//          int productPrice, int productStock) {
//    ProductDto productDto = getProductDto(
//            productId, productName, productPrice, productStock);
//
//    ProductEntity productEntity = getProductEntity(
//            productId, productName, productPrice, productStock);
//    this.productRepository.save(productEntity);
//
//    return productDto;
//  }
//  public List<ProductDto> getProductList() {
//    List<ProductEntity> productList = productRepository.findAll();
//    List<ProductDto> dtoList = new ArrayList<>();
//    productList.forEach(p -> {
//      ProductDto productDto = new ProductDto(
//        p.getProductId(),p.getProductName(),p.getProductPrice(),p.getProductStock()
//      );
//      dtoList.add(productDto);
//    });
//    return dtoList;
//  }
//
//  private ProductDto getProductDto(
//          String productId, String productName,
//          int productPrice, int productStock){
//    return new ProductDto(
//            productId,productName,productPrice,productStock
//    );
//  }
//
//  private ProductEntity getProductEntity(
//          String productId, String productName,
//          Integer productPrice, Integer productStock){
//    return new ProductEntity(
//            productId, productName, productPrice, productStock
//    );
//  }
//}
