package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
