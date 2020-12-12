package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.entity.DoctorEntity;
import project1.entity.DrogEntity;
import project1.repository.DrogRepository;
import project1.service.DrogService;

import java.util.List;

@Service
public class DrogServiceImpl implements DrogService {

    @Autowired
    DrogRepository drogRp;

    @Override
    public void addDrog(DrogEntity d) {
        drogRp.save(d);
    }

    @Override
    public List<DrogEntity> getList() {
        List<DrogEntity> list = drogRp.findAll();
        return list;
    }

    @Override
    public void editDrog(DrogEntity d, int id) {
        DrogEntity drog = d;
        drog.setId(id);
        drogRp.save(drog);
    }

    @Override
    public void deleteDrog(int id) {
        drogRp.deleteById(id);
    }
}
