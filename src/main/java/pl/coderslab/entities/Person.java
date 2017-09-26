package pl.coderslab.entities;

/**
 * Add roles
 */

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Set;

@Data
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    String firstName;
    @NotBlank
    @Column(updatable = false)
    String lastName;
    @Email
    @NotEmpty
    String email;
    @Column(name = "password")
    @Length(min = 5)
    @NotEmpty
    @Transient
    private String password;
    private String githubLogin;
    @Lob
    private String description;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}

