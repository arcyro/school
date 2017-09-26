package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entities.Person;
import pl.coderslab.entities.Role;
import pl.coderslab.entities.User;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p INNER JOIN p.roles r WHERE r IN (:roles)")
    List<Person> findByRoles(@Param("roles") Collection<Role> roles);

    List<Person> findAllByRolesName(String name);

    Person findByEmail(String email);


}
