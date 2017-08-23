package pl.coderslab.entities;

/**
 * Add roles
 */

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    String firstName;
    String lastName;
    String email;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}

