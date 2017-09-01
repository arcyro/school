package pl.coderslab.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class RepoPullRequest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StudentGroupRepo studentGroupRepo;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CodersLabRepo codersLabRepo;

    LocalDateTime created;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean checked = false;

    private String sshUrl;

    private int branch;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }


}
