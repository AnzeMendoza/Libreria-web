package edu.sucho.libreriaweb.repository;

import edu.sucho.libreriaweb.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    Editorial getByNombre(String nombre);
}
