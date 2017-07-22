package pl.coderslab.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    String name;
    @Lob
    String description;
    double maxPoint;
}
