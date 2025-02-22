package com.me.sbb.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity(name="product")
@Getter
@Setter
public class ProductEntity {

  @Id
  String id;

  String productName;
  Integer price;
  Integer stocks;
}
