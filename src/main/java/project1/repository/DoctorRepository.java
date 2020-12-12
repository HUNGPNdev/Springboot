package project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project1.entity.DoctorEntity;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    @Query("select u from DoctorEntity u where u.name like %?1%")
    List<DoctorEntity> searchByName(@Param("name") String name);
}
