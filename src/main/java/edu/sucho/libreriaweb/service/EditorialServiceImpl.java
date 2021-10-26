package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.model.Editorial;
import edu.sucho.libreriaweb.repository.BaseRepository;

public class EditorialServiceImpl extends BaseServiceImpl<Editorial, Long> implements EditorialService{
    public EditorialServiceImpl(BaseRepository<Editorial, Long> baseRepository) {
        super(baseRepository);
    }
}
