package project1.service;

import project1.entity.DiseaseEntity;
import project1.entity.DrogEntity;

import java.util.List;

public interface DiseaseService {
    void addDisease(DiseaseEntity d);
    List<DiseaseEntity> getList();
    void editDisease(DiseaseEntity d, int id);
    void deleteDisease(int id);
}
