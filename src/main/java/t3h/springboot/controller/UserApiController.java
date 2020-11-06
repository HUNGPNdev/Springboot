package t3h.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t3h.springboot.entitis.User;
import t3h.springboot.service.UserService;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user1 = userService.getUserById(id);
//        System.out.println(user1.getFullName());
        return ResponseEntity.ok(user1);
    }
}
