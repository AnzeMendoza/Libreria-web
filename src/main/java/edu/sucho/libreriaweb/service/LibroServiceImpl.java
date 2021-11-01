package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Libro;
import edu.sucho.libreriaweb.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Integer> implements LibroService{
    public LibroServiceImpl(BaseRepository<Libro, Integer> baseRepository) {
        super(baseRepository);
    }
}
