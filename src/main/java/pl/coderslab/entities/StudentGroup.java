package pl.coderslab.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Data
@Entity
@EqualsAndHashCode
public class StudentGroup {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",unique=true)
    String name;
    @OneToMany(mappedBy = "studentGroup", cascade=CascadeType.REMOVE)
    private List<Student> students;
    LocalDate start;
    LocalDate end;
    @ManyToOne
    City city;
    @ManyToOne
    Person mentor;
    @ManyToOne
    Person customerService;
    private Integer githubTeamId;

    @OneToMany(mappedBy = "studentGroup", cascade=CascadeType.REMOVE)
    private List<StudentGroupRepo> studentGroupRepos = new ArrayList<>();
}
