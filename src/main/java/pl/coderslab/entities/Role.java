package pl.coderslab.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(name="role")
    private String role;
}
