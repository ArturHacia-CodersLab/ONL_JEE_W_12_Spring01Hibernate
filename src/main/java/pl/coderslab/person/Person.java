package pl.coderslab.person;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = Person.TABLE_NAME)
@NoArgsConstructor
@Data
public class Person {
    public static final String TABLE_NAME = "people";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;
    private String password;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private PersonDetails personDetails;
}
