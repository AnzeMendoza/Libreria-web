package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutorService  {

    void guardar(Autor autor);
    /*{
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        autorRepository.save(autor);
    }*/

    void actualizar(Autor autor);

    void eliminar(Integer id);

    Autor obtenerUnAutor(Integer id);
    /*{

        Autor autorEncontrado = null;
        return autorRepository.getById(id);
    }*/

    List<Autor> listarAutores();
    /*{
        return autorRepository.findAll();
    }*/
}
