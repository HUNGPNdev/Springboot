package btvn.lesson18.repository;

import btvn.lesson18.entities.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {
}
