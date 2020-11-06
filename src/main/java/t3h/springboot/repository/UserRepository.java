package t3h.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t3h.springboot.entitis.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
