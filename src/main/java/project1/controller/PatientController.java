package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project1.entity.DoctorEntity;
import project1.entity.PatientEntity;
import project1.service.PatientService;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientService paSv;

    @GetMapping("/add-patient")
    public String addPatient() {
        return "patient/addPatient";
    }

    @PostMapping("/add-patient")
    public String add(@ModelAttribute("patient") PatientEntity pa, Model model) {
        paSv.addPatient(pa);
        model.addAttribute("msg", "Đã thêm");
        return "patient/addPatient";
    }

    @GetMapping("/list-patient")
    public String listPatient(Model model) {
        List<PatientEntity> list = paSv.getList();
        model.addAttribute("list", list);
        return "patient/listPatient";
    }

    @GetMapping("/edit-patient/{id}")
    public String updatePatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "patient/editPatient";
    }

    @PostMapping("/edit-patient/{id}")
    public String updateDoctor(@PathVariable("id") int id, @ModelAttribute("doctor") PatientEntity pa) {
        paSv.editPatient(pa, id);
        return "redirect:/list-patient";
    }

    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        paSv.deletePatient(id);
        return "redirect:/list-patient";
    }

}
