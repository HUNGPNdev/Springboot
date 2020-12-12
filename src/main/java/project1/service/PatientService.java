package project1.service;

import project1.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    void addPatient(PatientEntity pa);
    List<PatientEntity> getList();
    void editPatient(PatientEntity pa, int id);
    void deletePatient(int id);
    List<PatientEntity> searchByName(String name);
}
