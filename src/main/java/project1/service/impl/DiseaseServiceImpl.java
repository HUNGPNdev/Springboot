package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.entity.DiseaseEntity;
import project1.repository.DiseaseRepository;
import project1.service.DiseaseService;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    DiseaseRepository diRp;

    @Override
    public void addDisease(DiseaseEntity d) {
        diRp.save(d);
    }

    @Override
    public List<DiseaseEntity> getList() {
        List<DiseaseEntity> list = diRp.findAll();
        return list;
    }

    @Override
    public void editDisease(DiseaseEntity d, int id) {
        DiseaseEntity di = d;
        di.setD_id(id);
        diRp.save(di);
    }

    @Override
    public void deleteDisease(int id) {
        diRp.deleteById(id);
    }
}
