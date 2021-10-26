package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Libro;
import edu.sucho.libreriaweb.repository.BaseRepository;

public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService{
    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }
}
