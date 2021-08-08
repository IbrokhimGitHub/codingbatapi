package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
