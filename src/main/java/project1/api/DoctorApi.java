package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project1.entity.DoctorEntity;
import project1.repository.DoctorRepository;

@RestController
public class DoctorApi {

    @Autowired
    DoctorRepository docRp;

    @PostMapping(value = "/getDocById/{id}")
    public ResponseEntity<DoctorEntity> getUserById(@PathVariable("id") Long id) {
        DoctorEntity d = docRp.findById(id).get();
        return ResponseEntity.ok(d);
    }
}
