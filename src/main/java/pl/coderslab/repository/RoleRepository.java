package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByRole(String role);
}
