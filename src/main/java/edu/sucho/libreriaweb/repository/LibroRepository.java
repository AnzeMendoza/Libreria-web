package edu.sucho.libreriaweb.repository;

import edu.sucho.libreriaweb.model.Libro;
import org.springframework.stereotype.Repository;


@Repository
public interface LibroRepository extends BaseRepository<Libro, Integer> {
}
