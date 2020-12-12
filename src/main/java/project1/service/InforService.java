package project1.service;

import project1.dto.Info2DTO;
import project1.dto.InfoDTO;
import project1.entity.Infor_detailEntity;

import java.util.List;

public interface InforService {
    void addInfo(InfoDTO in);
    List<Info2DTO> getList();
    void editInfo(InfoDTO in, int id);
    void deleteInfo(int id);
}
