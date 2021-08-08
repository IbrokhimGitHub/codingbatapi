package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.Category;
import uz.pdp.online.codingbatapi.entity.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    boolean existsByName(String name);
}
