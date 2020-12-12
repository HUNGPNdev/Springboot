package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.entity.NurseEntity;
import project1.repository.NurseRepository;
import project1.service.NurseService;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    NurseRepository nuRp;

    @Override
    public void addNurse(NurseEntity nui) {
        nuRp.save(nui);
    }

    @Override
    public List<NurseEntity> getList() {
        List<NurseEntity> list = nuRp.findAll();
        return list;
    }

    @Override
    public void editNurse(NurseEntity nui, Long id) {
        NurseEntity n = nui;
        n.setN_id(id);
        nuRp.save(n);
    }

    @Override
    public void deleteNurse(Long id) {
        nuRp.deleteById(id);
    }

    @Override
    public NurseEntity getById(Long id) {
        return nuRp.findById(id).get();
    }
}
