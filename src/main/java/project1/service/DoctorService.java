package project1.service;

import project1.entity.DoctorEntity;
import java.util.List;

public interface DoctorService {
    void addDoctor(DoctorEntity doc);
    List<DoctorEntity> getList();
    void editDoctor(DoctorEntity doc, Long id);
    void deleteDoctor(Long d_id);
    List<DoctorEntity> searchByName(String name);

}
