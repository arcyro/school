package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.City;
import pl.coderslab.entities.CodersLabRepo;
import pl.coderslab.entities.Person;

import java.util.List;

public interface CodersLabRepoRepository extends JpaRepository<CodersLabRepo, Long> {


    List<CodersLabRepo> findAllByActive(boolean active);
}
