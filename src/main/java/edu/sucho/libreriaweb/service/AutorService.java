package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void guardar(String nombre, Boolean alta){
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        autorRepository.save(autor);
    }

    @Transactional(readOnly = true)
    public Autor obtenerPorId(Integer id){
        Autor autorEncontrado = null;
        return autorRepository.getById(id);
    }

    @Transactional(readOnly = true)
    public Autor obtenerPorNombre(String nombre){
        Autor autorEncontrado = null;
        autorEncontrado = autorRepository.getByNombre(nombre);
        return autorEncontrado;
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

}
