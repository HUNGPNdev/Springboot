package btvn.lesson18.service;

import btvn.lesson18.entities.BrandEntity;

import java.util.List;

public interface BrandService {
    List<BrandEntity> getAllBrand();
    BrandEntity getBrandById(int id);
}
