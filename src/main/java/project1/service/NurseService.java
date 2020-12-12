package project1.service;

import project1.entity.NurseEntity;

import java.util.List;

public interface NurseService {
    void addNurse(NurseEntity nui);
    List<NurseEntity> getList();
    void editNurse(NurseEntity nui, Long id);
    void deleteNurse(Long id);
    NurseEntity getById(Long id);
}
