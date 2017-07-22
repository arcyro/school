package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.StudentExam;
import pl.coderslab.entities.StudentGroup;
import pl.coderslab.entities.StudentGroupExam;

import java.util.List;

public interface StudentGroupExamRepository extends JpaRepository<StudentGroupExam, Long> {


    List<StudentGroupExam> findAllByStudentGroupId(Long id);
}
