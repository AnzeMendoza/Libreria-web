package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.model.Editorial;
import edu.sucho.libreriaweb.model.Libro;
import edu.sucho.libreriaweb.repository.AutorRepository;
import edu.sucho.libreriaweb.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void guardar(){

        Autor autorAGuardar = new Autor();
        autorAGuardar.setNombre("Sadosky");
        autorAGuardar.setAlta(true);

        if(autorRepository.getByNombre(autorAGuardar.getNombre()).toString().isEmpty()){
            autorRepository.save(autorAGuardar);
        }


        Editorial editorialAGuardar = new Editorial();
        editorialAGuardar.setNombre("Alsina");
        editorialAGuardar.setAlta(true);

        Libro libroAGuardar = new Libro();
        libroAGuardar.setTitulo("Elementos de Algebra");
        libroAGuardar.setAutor(autorAGuardar);
        libroAGuardar.setEditorial(editorialAGuardar);

        libroRepository.save(libroAGuardar);
    }

}
