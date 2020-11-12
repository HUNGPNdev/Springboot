package btvn.lesson18.controller;

import btvn.lesson18.entities.BrandEntity;
import btvn.lesson18.entities.ColorEntity;
import btvn.lesson18.service.BrandService;
import btvn.lesson18.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiEntity {
    @Autowired
    BrandService brandService;

    @Autowired
    ColorService colorService;

    @RequestMapping(value = "/getBrandById", method = RequestMethod.POST)
    public ResponseEntity<BrandEntity> getUserById() {
        return null;
    }
}
