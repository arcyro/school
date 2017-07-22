package pl.coderslab.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Entity
public class StudentGroupExam {

    @Id
    @GeneratedValue
    private Long id;
    LocalDate created;
    String repo;
    @ManyToOne
    Person checker;
    @ManyToOne
    Exam exam;
    @ManyToOne
    StudentGroup studentGroup;
    @OneToMany(mappedBy = "studentGroupExam")
    List<StudentExam> studentExams;
    Double points;
}
