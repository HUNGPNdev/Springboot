package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project1.entity.DoctorEntity;
import project1.service.DoctorService;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorService docSv;

    @GetMapping("/add-doctor")
    public String addDoctor() {
        return "doctor/adddoctor";
    }

    @PostMapping("/add-doctor")
    public String postDoctor(@ModelAttribute("doctor") DoctorEntity doc, Model model) {
        docSv.addDoctor(doc);
        model.addAttribute("msg", "Đã thêm");
        return "doctor/adddoctor";
    }

    @GetMapping("/list-doctor")
    public String getListDoctor(Model model) {
        List<DoctorEntity> list = docSv.getList();
        model.addAttribute("list", list);
        return "doctor/listDoctor";
    }

    @GetMapping("/edit-doctor/{id}")
    public String getupdateDoctor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "doctor/updateDoctor";
    }

    @PostMapping("/edit-doctor/{id}")
    public String updateDoctor(@PathVariable("id") Long id, Model model, @ModelAttribute("doctor") DoctorEntity doc) {
        docSv.editDoctor(doc, id);
        return "redirect:/list-doctor";
    }

    @GetMapping("/delete-doctor/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        docSv.deleteDoctor(id);
        return "redirect:/list-doctor";
    }

    @GetMapping("/search-doctor/{name}")
    public String searchDoctorByName(@PathVariable("name") String name, Model model) {
        List<DoctorEntity> list = docSv.searchByName(name);
        model.addAttribute("list", list);
        return "doctor/searchDoctor";
    }

}
