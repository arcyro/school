package pl.coderslab.entities;


import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Entity
public class StudentGroup {

    @Id
    @GeneratedValue
    private Long id;
    String name;
    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;
    LocalDate start;
    LocalDate end;
    @ManyToOne
    City city;
}
