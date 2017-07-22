package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
