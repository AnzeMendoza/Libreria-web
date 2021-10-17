package edu.sucho.libreriaweb.repository;

import edu.sucho.libreriaweb.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Autor getByNombre(String nombre);
}
