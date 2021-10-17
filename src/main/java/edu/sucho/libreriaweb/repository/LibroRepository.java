package edu.sucho.libreriaweb.repository;

import edu.sucho.libreriaweb.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
