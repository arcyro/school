package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.coderslab.entities.Exam;
import pl.coderslab.entities.StudentGroup;

public interface StudentGroupRepository extends PagingAndSortingRepository<StudentGroup, Long> {


}
