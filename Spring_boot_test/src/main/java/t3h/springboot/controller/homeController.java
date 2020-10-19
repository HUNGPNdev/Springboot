package t3h.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import t3h.springboot.model.Student;
import t3h.springboot.service.IListStudent;

@Controller
public class homeController {
	
	@Autowired
	private IListStudent list;
	
	@RequestMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("hello","Hùng Đây Rồi");
		model.addAttribute("list",list.listStudent());
		return "home";
	}
	@RequestMapping("/add")
	public String addSt(@ModelAttribute(name = "student") Student student) {
		return "addStudent";
	}
	
	@RequestMapping("/addst")
	public String saveAddSt(Model model, @RequestParam String id, @RequestParam String name) {
		list.getStudent(new Student(id, name));
		model.addAttribute("hello","Đã Thêm");
		return "turnBack";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAddSt(Model model, @PathVariable String id) {
		list.deleteStudent(id);
		model.addAttribute("hello","Đã Xóa");
		return "turnBack";
	}
	
	@RequestMapping("/edit/{id}/{name}")
	public String editSt(@ModelAttribute(name = "student") Student student) {
		return "editStudent";
	}
	
	@RequestMapping("/postEdit/{ida}")
	public String editSt(Model model, @PathVariable String ida, @RequestParam String id, @RequestParam String name) {
		list.editStudent(ida, id, name);
		String str = "Đã sửa";
		model.addAttribute("hello",str);
		return "turnBack";
	}
}
