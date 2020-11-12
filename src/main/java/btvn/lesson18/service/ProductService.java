package btvn.lesson18.service;

import btvn.lesson18.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    void insertProduct(ProductEntity p);
    ProductEntity getProductById(int id);
}
