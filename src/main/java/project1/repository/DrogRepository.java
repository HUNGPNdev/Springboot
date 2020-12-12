package project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project1.entity.DrogEntity;

@Repository
public interface DrogRepository extends JpaRepository<DrogEntity, Integer> {
}
