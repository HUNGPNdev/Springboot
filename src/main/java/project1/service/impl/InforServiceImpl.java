package project1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project1.dto.Info2DTO;
import project1.dto.InfoDTO;
import project1.entity.DiseaseEntity;
import project1.entity.DrogEntity;
import project1.entity.Infor_detailEntity;
import project1.repository.*;
import project1.service.InforService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InforServiceImpl implements InforService {

    @Autowired
    InforRepository inRp;

    @Autowired
    PatientRepository patRp;

    @Autowired
    DiseaseRepository diRp;

    @Autowired
    DoctorRepository docRp;

    @Autowired
    NurseRepository nurRp;

    @Autowired
    DrogRepository drogRp;


    @Override
    public void addInfo(InfoDTO in) {
        Infor_detailEntity info = new Infor_detailEntity();
        double fee = 0;

        info.setPatient_id(patRp.findById(in.getPatient_id()).get());

        List<DiseaseEntity> diseaseList = new ArrayList<>();
        for (int i: in.getDisease_id()) {
            fee += diRp.findById(i).get().getPrice();
            diseaseList.add(diRp.findById(i).get());
        }
        info.setDisease_id(diseaseList);
        info.setDate_in(in.getDate_in());
        info.setDate_out(in.getDate_out());

        List<DrogEntity> drogList = new ArrayList<>();
        for (int i: in.getDrog_id()) {
            fee += drogRp.findById(i).get().getPrice();
            drogList.add(drogRp.findById(i).get());
        }
        info.setDrog_id(drogList);
        info.setTotal_fee(fee);
        info.setDoctor(docRp.findById(in.getDoctor_id()).get());
        info.setNurse(nurRp.findById(in.getNurse_id()).get());
        System.out.println(fee);
        System.out.println(in.toString());
        inRp.save(info);
    }

    @Override
    public List<Info2DTO> getList() {
        List<Info2DTO> li = new ArrayList<>();

        for (Infor_detailEntity l: inRp.findAll()) {
            String disease = "";
            for (DiseaseEntity dis: l.getDisease_id()) {
                disease += dis.getName()+",";
            }
            String dr = "";
            for (DrogEntity drog: l.getDrog_id()) {
                dr += drog.getName()+",";
            }
            Info2DTO info = new Info2DTO();
            info.setId(l.getId());
            info.setPatient(l.getPatient_id().getName());
            info.setDisease_id(disease);
            info.setDate_in(l.getDate_in());
            info.setDate_out(l.getDate_out());
            info.setDrog_id(dr);
            info.setTotal_fee(l.getTotal_fee());
            info.setDoctor(l.getDoctor().getName());
            info.setNurse(l.getNurse().getName());
            li.add(info);
        }
        return li;
    }

    @Override
    public void editInfo(InfoDTO in, int id) {
        Infor_detailEntity info = new Infor_detailEntity();
        info.setId(id);

        double fee = 0;

        info.setPatient_id(patRp.findById(in.getPatient_id()).get());

        List<DiseaseEntity> diseaseList = new ArrayList<>();
        for (int i: in.getDisease_id()) {
            fee += diRp.findById(i).get().getPrice();
            diseaseList.add(diRp.findById(i).get());
        }
        info.setDisease_id(diseaseList);
        info.setDate_in(in.getDate_in());
        info.setDate_out(in.getDate_out());

        List<DrogEntity> drogList = new ArrayList<>();
        for (int i: in.getDrog_id()) {
            fee += drogRp.findById(i).get().getPrice();
            drogList.add(drogRp.findById(i).get());
        }
        info.setDrog_id(drogList);
        info.setTotal_fee(fee);
        info.setDoctor(docRp.findById(in.getDoctor_id()).get());
        info.setNurse(nurRp.findById(in.getNurse_id()).get());
        System.out.println(fee);
        System.out.println(in.toString());
        System.out.println(info);
        inRp.save(info);
    }

    @Override
    public void deleteInfo(int id) {
        inRp.deleteById(id);
    }
}
