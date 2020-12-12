package project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project1.entity.DoctorEntity;
import project1.entity.NurseEntity;
import project1.service.NurseService;

import java.util.List;

@Controller
public class NoiseController {

    @Autowired
    NurseService nuSv;

    @GetMapping("/add-nurse")
    public String addNoise() {
        return "nurse/addNurse";
    }

    @GetMapping("/list-nurse")
    public String listNoise(Model model) {
        List<NurseEntity> list = nuSv.getList();
        model.addAttribute("list", list);
        return "nurse/listNurse";
    }

    @PostMapping("/add-nurse")
    public String paddNoise(Model model, @ModelAttribute("noise") NurseEntity nui) {
        nuSv.addNurse(nui);
        model.addAttribute("msg", "Đã thêm");
        return "nurse/addNurse";
    }

    @GetMapping("/edit-nurse/{id}")
    public String getupdateNurse(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "nurse/updateNurse";
    }

    @PostMapping("/edit-nurse/{id}")
    public String updateDoctor(@PathVariable("id") Long id, Model model, @ModelAttribute("doctor") NurseEntity nui) {
        nuSv.editNurse(nui, id);
        return "redirect:/list-nurse";
    }

    @GetMapping("/delete-nurse/{id}")
    public String deleteNurse(@PathVariable("id") Long id) {
        nuSv.deleteNurse(id);
        return "redirect:/list-nurse";
    }

}
