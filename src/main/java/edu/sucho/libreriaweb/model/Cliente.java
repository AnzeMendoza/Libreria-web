package edu.sucho.libreriaweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long documento;

    @Column(length = 64)
    private String nombre;

    @Column(length = 64)
    private String apellido;

    @Column(length = 64)
    private String telefono;

    private Boolean alta = true;
}
