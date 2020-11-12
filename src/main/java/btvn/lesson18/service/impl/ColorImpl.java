package btvn.lesson18.service.impl;

import btvn.lesson18.entities.BrandEntity;
import btvn.lesson18.entities.ColorEntity;
import btvn.lesson18.repository.ColorRepository;
import btvn.lesson18.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorImpl implements ColorService {

    @Autowired
    ColorRepository colorRepo;

    @Override
    public List<ColorEntity> getAllColor() {
        return colorRepo.findAll();
    }

    @Override
    public ColorEntity getColorById(int id) {
        ColorEntity colorEntity = null;
        for (ColorEntity x: getAllColor()) {
            if (id == x.getColorId()) {
                colorEntity = x;
            }
        }
        return colorEntity;
    }

}
