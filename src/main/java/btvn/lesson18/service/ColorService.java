package btvn.lesson18.service;

import btvn.lesson18.entities.ColorEntity;

import java.util.List;

public interface ColorService {
    List<ColorEntity> getAllColor();
    ColorEntity getColorById(int id);
}
