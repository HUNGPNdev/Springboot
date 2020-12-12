package project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project1.entity.DiseaseEntity;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Integer> {
}
