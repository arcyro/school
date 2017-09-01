package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Student;
import pl.coderslab.entities.StudentGroupRepo;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    Student findOneByGithubLogin(String gitHubLogin);

    List<Student> findAllByStudentGroupId(long id);
}
