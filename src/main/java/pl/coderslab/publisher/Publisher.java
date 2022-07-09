package pl.coderslab.publisher;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Publisher.TABLE_NAME)
@Data
public class Publisher {
    final static String TABLE_NAME = "publishers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
