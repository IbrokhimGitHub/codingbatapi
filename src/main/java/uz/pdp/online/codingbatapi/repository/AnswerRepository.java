package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.entity.Example;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    boolean existsByName(String name);
}
