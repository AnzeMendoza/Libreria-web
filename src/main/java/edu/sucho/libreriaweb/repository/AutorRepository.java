package edu.sucho.libreriaweb.repository;

import edu.sucho.libreriaweb.model.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Integer> {
}
