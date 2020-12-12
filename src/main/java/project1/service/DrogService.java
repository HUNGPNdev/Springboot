package project1.service;

import project1.entity.DrogEntity;

import java.util.List;

public interface DrogService {
    void addDrog(DrogEntity d);
    List<DrogEntity> getList();
    void editDrog(DrogEntity d, int id);
    void deleteDrog(int id);
}
