package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project1.entity.DrogEntity;
import project1.entity.PatientEntity;
import project1.service.DrogService;
import project1.service.PatientService;

import java.util.List;

@Controller
public class DrogController {

    @Autowired
    DrogService drogSv;

    @GetMapping("/add-drog")
    public String addPatient() {
        return "drog/addDrog";
    }

    @PostMapping("/add-drog")
    public String add(@ModelAttribute("patient") DrogEntity d, Model model) {
        drogSv.addDrog(d);
        model.addAttribute("msg", "Đã thêm");
        return "drog/addDrog";
    }

    @GetMapping("/list-drog")
    public String listDrog(Model model) {
        List<DrogEntity> list = drogSv.getList();
        model.addAttribute("list", list);
        return "drog/listDrog";
    }

    @GetMapping("/edit-drog/{id}")
    public String updateDrog(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "drog/editDrog";
    }

    @PostMapping("/edit-drog/{id}")
    public String updateDrog(@PathVariable("id") int id, @ModelAttribute("doctor") DrogEntity pa) {
        drogSv.editDrog(pa, id);
        return "redirect:/list-drog";
    }

    @GetMapping("/delete-drog/{id}")
    public String deleteDrog(@PathVariable("id") int id) {
        drogSv.deleteDrog(id);
        return "redirect:/list-drog";
    }
}
