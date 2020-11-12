package btvn.lesson18.service.impl;

import btvn.lesson18.entities.ColorEntity;
import btvn.lesson18.entities.ProductEntity;
import btvn.lesson18.repository.ProductRepository;
import btvn.lesson18.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepository prodSv;

    @Override
    public List<ProductEntity> getAllProduct() {
        return prodSv.findAll();
    }



    @Override
    public void insertProduct(ProductEntity p) {
        prodSv.save(p);
    }

    @Override
    public ProductEntity getProductById(int id) {
        ProductEntity productEntity = null;
        for (ProductEntity x: getAllProduct()) {
            if (id == x.getProductId()) {
                productEntity = x;
            }
        }
        return productEntity;
    }
}
