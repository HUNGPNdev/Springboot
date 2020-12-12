package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project1.entity.DiseaseEntity;
import project1.entity.PatientEntity;
import project1.service.DiseaseService;

import java.util.List;

@Controller
public class DiseaseController {

    @Autowired
    DiseaseService diSv;

    @GetMapping("/add-disease")
    public String addDisease() {
        return "disease/addDisease";
    }

    @PostMapping("/add-disease")
    public String add(@ModelAttribute("disease") DiseaseEntity d, Model model) {
        diSv.addDisease(d);
        model.addAttribute("msg", "Đã thêm");
        return "disease/addDisease";
    }

    @GetMapping("/list-disease")
    public String listDisease(Model model) {
        List<DiseaseEntity> list = diSv.getList();
        model.addAttribute("list", list);
        return "disease/listDisease";
    }

    @GetMapping("/edit-disease/{id}")
    public String updateDisease(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "disease/editDisease";
    }

    @PostMapping("/edit-disease/{id}")
    public String updateDisease(@PathVariable("id") int id, @ModelAttribute("disease") DiseaseEntity pa) {
        diSv.editDisease(pa, id);
        return "redirect:/list-disease";
    }

    @GetMapping("/delete-disease/{id}")
    public String deleteDisease(@PathVariable("id") int id) {
        diSv.deleteDisease(id);
        return "redirect:/list-disease";
    }

}
