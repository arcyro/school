package pl.coderslab.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CodersLabRepo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sshUrl;
    @Lob
    private String description;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isExam;

    @OneToMany(mappedBy = "codersLabRepo")
    private List<StudentGroupRepo> studentGroupRepos = new ArrayList<>();
}
