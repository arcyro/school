package pl.coderslab.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private List<Address> addresses = new ArrayList<>();
    String firstName;
}