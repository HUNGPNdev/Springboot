package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.entity.PatientEntity;
import project1.repository.PatientRepository;
import project1.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository paRp;


    @Override
    public void addPatient(PatientEntity pa) {
        paRp.save(pa);
    }

    @Override
    public List<PatientEntity> getList() {
        List<PatientEntity> list = paRp.findAll();
        return list;
    }

    @Override
    public void editPatient(PatientEntity pa, int id) {
        PatientEntity p = pa;
        p.setP_id(id);
        paRp.save(p);
    }

    @Override
    public void deletePatient(int id) {
        paRp.deleteById(id);
    }

    @Override
    public List<PatientEntity> searchByName(String name) {
        return null;
    }
}
