package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.City;
import pl.coderslab.entities.RepoPullRequest;
import pl.coderslab.entities.StudentGroupExam;

import java.util.List;

public interface RepoPullRequestRepository extends JpaRepository<RepoPullRequest, Long> {


//    List<RepoPullRequest> findAllByStudentGroupRepoId(Long id);
}
