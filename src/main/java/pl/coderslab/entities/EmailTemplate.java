package pl.coderslab.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class EmailTemplate {
    @Id
    @GeneratedValue
    private Long id;
    String title;
    @Lob
    String content;
}
