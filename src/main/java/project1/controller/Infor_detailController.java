package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project1.dto.Info2DTO;
import project1.dto.InfoDTO;
import project1.entity.DiseaseEntity;
import project1.entity.DrogEntity;
import project1.entity.Infor_detailEntity;
import project1.entity.NurseEntity;
import project1.repository.*;
import project1.service.InforService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Infor_detailController {

    @Autowired
    InforService inSv;

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

    @GetMapping("/add-info")
    public String addInfo(Model model) {
        model.addAttribute("patients", patRp.findAll());
        model.addAttribute("diseases", diRp.findAll());
        model.addAttribute("doctors", docRp.findAll());
        model.addAttribute("nurses", nurRp.findAll());
        model.addAttribute("drogs", drogRp.findAll());
        return "infor_details/addInfor";
    }

    @PostMapping("/add-info")
    public String add(@ModelAttribute("info") InfoDTO in, Model model) {
        inSv.addInfo(in);
        return "redirect:/add-info";
    }

    @GetMapping("/list-info")
    public String listInfo(Model model) {
        model.addAttribute("list", inSv.getList());
        return "infor_details/listInfor";
    }

    @GetMapping("/edit-info/{id}")
    public String editInfo(Model model, @PathVariable("id") int id) {
        model.addAttribute("patients", patRp.findAll());
        model.addAttribute("diseases", diRp.findAll());
        model.addAttribute("doctors", docRp.findAll());
        model.addAttribute("nurses", nurRp.findAll());
        model.addAttribute("drogs", drogRp.findAll());
        model.addAttribute("id", id);
        return "infor_details/editInfo";
    }

    @PostMapping("/edit-info/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("info") InfoDTO in, Model model) {
        inSv.editInfo(in, id);
        return "redirect:/list-info";
    }

    @GetMapping("/delete-info/{id}")
    public String deleteInfo(@PathVariable("id") int id) {
        inSv.deleteInfo(id);
        return "redirect:/list-info";
    }

}
