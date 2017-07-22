package pl.coderslab.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class StudentExamExercise {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    Student student;
    String comment;
    @ManyToOne
    Exercise exercise;
    Boolean checked = false;
    @ManyToOne
    StudentExam studentExam;
    Double points;
    
}
