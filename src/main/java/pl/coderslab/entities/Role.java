package pl.coderslab.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="role")
    private String role;
}
