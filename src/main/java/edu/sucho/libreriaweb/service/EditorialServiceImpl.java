package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Editorial;
import edu.sucho.libreriaweb.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl extends BaseServiceImpl<Editorial, Integer> implements EditorialService{
    public EditorialServiceImpl(BaseRepository<Editorial, Integer> baseRepository) {
        super(baseRepository);
    }
}
