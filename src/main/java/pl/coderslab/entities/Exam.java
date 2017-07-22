package pl.coderslab.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Exam {

    @Id
    @GeneratedValue
    private Long id;

    String name;
    String repoUrl;

    @OneToMany
    private List<Exercise> exercises;
}
