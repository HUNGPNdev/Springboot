package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project1.entity.DrogEntity;
import project1.entity.PatientEntity;
import project1.repository.DrogRepository;
import project1.repository.PatientRepository;

@RestController
public class DrogApi {
    @Autowired
    DrogRepository drogRp;

    @PostMapping(value = "/getDrogById/{id}")
    public ResponseEntity<DrogEntity> getUserById(@PathVariable int id) {
        DrogEntity pa = drogRp.findById(id).get();
        return ResponseEntity.ok(pa);
    }
}
