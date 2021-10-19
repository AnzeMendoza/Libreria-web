package edu.sucho.libreriaweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*@Entity*/
@Getter
@Setter
@Table(name = "editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64)
    private String nombre;

    private Boolean alta;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;
}
