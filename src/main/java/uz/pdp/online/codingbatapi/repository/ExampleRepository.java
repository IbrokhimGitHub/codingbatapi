package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.Example;
import uz.pdp.online.codingbatapi.entity.Task;

public interface ExampleRepository extends JpaRepository<Example,Integer> {
    boolean existsByName(String name);
}
