package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.repository.BaseRepository;

public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }


}
