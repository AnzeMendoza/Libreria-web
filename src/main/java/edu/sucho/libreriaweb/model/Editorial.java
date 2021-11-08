package edu.sucho.libreriaweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "El nombre es obligatorio")
    @Size(min = 2, max = 64, message = "Min: 2 y Max: 64 caracteres")
    @Column(length = 64)
    private String nombre;

    private Boolean alta = true;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;
}
