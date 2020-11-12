package btvn.lesson18.service.impl;

import btvn.lesson18.entities.BrandEntity;
import btvn.lesson18.repository.BrandRepository;
import btvn.lesson18.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandImpl implements BrandService {

    @Autowired
    BrandRepository brandRepo;

    @Override
    public List<BrandEntity> getAllBrand() {
        return brandRepo.findAll();
    }

    @Override
    public BrandEntity getBrandById(int id) {
        BrandEntity brandEntity = null;
        for (BrandEntity x: getAllBrand()) {
            if (id == x.getBrandId()) {
                brandEntity = x;
            }
        }
//        Optional<BrandEntity> brand = brandRepo.findById(id);
//        if (brand.isPresent()) {
//            brandEntity = brand.get();
//        }
        return brandEntity;
    }
}
