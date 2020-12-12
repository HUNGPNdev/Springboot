package project1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project1.entity.Infor_detailEntity;
import project1.repository.InforRepository;

@RestController
public class InfoApi {
    @Autowired
    InforRepository infoRp;

    @PostMapping(value = "/getInfoById/{id}")
    public ResponseEntity<Infor_detailEntity> getUserById(@PathVariable int id) {
        Infor_detailEntity nu = infoRp.findById(id).get();
        return ResponseEntity.ok(nu);
    }
}
