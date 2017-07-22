package pl.coderslab.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Entity
public class StudentExam {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    Student student;
    String comment;
    @ManyToOne
    StudentGroupExam studentGroupExam;
    Boolean checked = false;
    @OneToMany(mappedBy = "studentExam")
    List<StudentExamExercise> examExerciseList;
    Double points;

}
