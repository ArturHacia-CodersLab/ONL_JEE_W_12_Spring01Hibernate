package pl.coderslab.author;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Author.TABLE_NAME)
@Data
public class Author {
    final static String TABLE_NAME = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
