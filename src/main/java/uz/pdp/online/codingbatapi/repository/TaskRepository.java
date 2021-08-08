package uz.pdp.online.codingbatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.codingbatapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    boolean existsByName(String name);
}
