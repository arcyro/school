package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Exam;
import pl.coderslab.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
