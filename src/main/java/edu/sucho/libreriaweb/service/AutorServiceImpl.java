package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Autor;
import edu.sucho.libreriaweb.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Integer> implements AutorService {
    public AutorServiceImpl(BaseRepository<Autor, Integer> baseRepository) {
        super(baseRepository);
    }
}