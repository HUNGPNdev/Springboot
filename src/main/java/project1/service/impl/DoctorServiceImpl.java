package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.entity.DoctorEntity;
import project1.repository.DoctorRepository;
import project1.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository docRp;

    @Override
    public void addDoctor(DoctorEntity doc) {
        docRp.save(doc);
    }

    @Override
    public List<DoctorEntity> getList() {
        return docRp.findAll();
    }

    @Override
    public void editDoctor(DoctorEntity doc, Long id) {
        DoctorEntity d = doc;
        d.setD_id(id);
        docRp.save(d);
    }

    @Override
    public void deleteDoctor(Long d_id) {
        docRp.deleteById(d_id);
    }

    @Override
    public List<DoctorEntity> searchByName(String name) {
        List<DoctorEntity> list = docRp.searchByName(name);
        return list;
    }
}
