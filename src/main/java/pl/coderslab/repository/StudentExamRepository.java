package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.StudentExam;
import pl.coderslab.entities.StudentGroup;

public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {

    
}
