package pl.coderslab.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = {"studentGroup", "id"})
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String githubLogin;

    @ManyToOne
    private StudentGroup studentGroup;
}
