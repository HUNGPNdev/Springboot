package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project1.entity.DiseaseEntity;
import project1.entity.DrogEntity;
import project1.repository.DiseaseRepository;
import project1.repository.DrogRepository;

@RestController
public class DiseaseApi {
    @Autowired
    DiseaseRepository diRp;

    @PostMapping(value = "/getDiseaseById/{id}")
    public ResponseEntity<DiseaseEntity> getUserById(@PathVariable int id) {
        DiseaseEntity pa = diRp.findById(id).get();
        return ResponseEntity.ok(pa);
    }
}
