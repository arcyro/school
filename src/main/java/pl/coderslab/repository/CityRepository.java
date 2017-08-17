package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.City;
import pl.coderslab.entities.Exam;

public interface CityRepository extends JpaRepository<City, Long> {

}
