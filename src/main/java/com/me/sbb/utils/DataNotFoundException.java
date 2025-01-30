package com.me.sbb.utils;

public class DataNotFoundException extends RuntimeException {
  public DataNotFoundException(String questionNotFound) {
    super(questionNotFound);
  }
}
