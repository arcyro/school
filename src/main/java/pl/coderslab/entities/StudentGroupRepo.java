package pl.coderslab.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class StudentGroupRepo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StudentGroup studentGroup;

    @ManyToOne
    private CodersLabRepo codersLabRepo;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean shared = false;
    LocalDate created;
    LocalDateTime sharedDate;

    private String name;
    private String sshUrl;

    @PrePersist
    protected void onCreate() {
        created = LocalDate.now();
    }

    public StudentGroupRepo(StudentGroup studentGroup, CodersLabRepo codersLabRepo, String name, String sshUrl) {
        this.studentGroup = studentGroup;
        this.codersLabRepo = codersLabRepo;
        this.name = name;
        this.sshUrl = sshUrl;
    }
}
