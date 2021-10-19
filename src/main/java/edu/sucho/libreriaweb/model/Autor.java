package edu.sucho.libreriaweb.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64)
    private String nombre;

    private Boolean alta;

    /*
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
    */
    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Autor autor = (Autor) o;
        return id != null && Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
