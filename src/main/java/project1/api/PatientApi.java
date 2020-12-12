package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project1.entity.NurseEntity;
import project1.entity.PatientEntity;
import project1.repository.PatientRepository;
import project1.service.NurseService;

@RestController
public class PatientApi {
    @Autowired
    PatientRepository paRp;

    @PostMapping(value = "/getPatientById/{id}")
    public ResponseEntity<PatientEntity> getUserById(@PathVariable int id) {
        PatientEntity pa = paRp.findById(id).get();
        return ResponseEntity.ok(pa);
    }
}
