package t3h.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import t3h.springboot.entitis.User;
import t3h.springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String getHome() {
        List<User> userList = userService.getALlUser();
//        userList.forEach(e-> System.out.println(e.getFullName()));
        return "login";
    }

    @RequestMapping("/userlist")
    public String getList(Model model) {
        model.addAttribute("users", userService.getALlUser());
        return "listUser";
    }

    @PostMapping("/edituser")
    public String editUser(Model model, @ModelAttribute User user) {
        userService.editById(user);
        return "redirect:/userlist";
    }

    @PostMapping("/authen-user")
    public String authenticate(Model model, @RequestParam String username, @RequestParam String password) {
        boolean result = userService.authUser(username,password);
        if (result == true) {
            return "redirect:/userlist";
        } else {
            model.addAttribute("ck", "Login Failure!");
            return "login";
        }
    }

    @PostMapping("/insert")
    public String authenticate(Model model, @ModelAttribute User user) {
        userService.insert(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/userlist";
    }
}
