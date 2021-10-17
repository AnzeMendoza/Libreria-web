package edu.sucho.libreriaweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64)
    private String nombre;

    private Boolean alta;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                ", libros=" + libros +
                '}';
    }
}
