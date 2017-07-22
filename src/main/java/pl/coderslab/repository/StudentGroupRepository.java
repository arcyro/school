package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Exam;
import pl.coderslab.entities.StudentGroup;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {


}
