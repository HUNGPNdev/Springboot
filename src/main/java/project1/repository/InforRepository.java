package project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project1.entity.Infor_detailEntity;

import java.util.List;

public interface InforRepository extends JpaRepository<Infor_detailEntity, Integer> {
    @Query("select u from Infor_detailEntity u")
    List<Infor_detailEntity> getAll();
}
