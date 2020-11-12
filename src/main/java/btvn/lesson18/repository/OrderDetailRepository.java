package btvn.lesson18.repository;

import btvn.lesson18.entities.Order_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Order_details, Integer> {
}
