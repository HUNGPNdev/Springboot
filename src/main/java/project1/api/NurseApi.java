package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project1.entity.NurseEntity;
import project1.service.NurseService;

@RestController
public class NurseApi {
    @Autowired
    NurseService nuSv;

    @PostMapping(value = "/getNurseById/{id}")
    public ResponseEntity<NurseEntity> getUserById(@PathVariable Long id) {
        NurseEntity nu = nuSv.getById(id);
        return ResponseEntity.ok(nu);
    }
}
