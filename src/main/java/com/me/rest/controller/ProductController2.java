//package com.me.sbb.rest.controller;
//
//import com.me.sbb.rest.dao.ProductDao;
//import com.me.sbb.rest.data.ProductDto;
//import com.me.sbb.rest.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductController2 {
//
//  private final ProductDao productDao;
//  private final ProductService productService;
//
//  @GetMapping("/product/{productId}")
//  public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") String productId) {
//    return ResponseEntity.ok(this.productService.getProduct(productId));
//  }
//  @GetMapping("/products")
//  public List<ProductDto> getProductList() {
//    return this.productService.getProductList();
//  }
//
//  @PostMapping("/product")
//  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
//    ProductDto product1 = productService.saveProduct(
//            productDto.getProductId(), productDto.getProductName(),
//            productDto.getProductPrice(), productDto.getProductStock());
//    return ResponseEntity.status(HttpStatus.CREATED).body(product1);
//  }
//}
