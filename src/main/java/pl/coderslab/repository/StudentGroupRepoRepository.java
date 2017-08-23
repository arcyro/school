package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.CodersLabRepo;
import pl.coderslab.entities.StudentGroupRepo;

import java.util.List;

public interface StudentGroupRepoRepository extends JpaRepository<StudentGroupRepo, Long> {


    List<StudentGroupRepo> findAllByStudentGroupId(long id);
}
