package pl.coderslab.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "addresses")
    private List<Person> owners = new ArrayList<>();
    String street;
}
