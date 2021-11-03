package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.exception.ExceptionBBDD;
import edu.sucho.libreriaweb.model.Editorial;
import edu.sucho.libreriaweb.repository.BaseRepository;
import edu.sucho.libreriaweb.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl extends BaseServiceImpl<Editorial, Integer> implements EditorialService{

    @Autowired
    private EditorialRepository editorialRepository;

    public EditorialServiceImpl(BaseRepository<Editorial, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public boolean deleteByIdSoft(int id) throws ExceptionBBDD {
        try {
            Optional<Editorial> editorialOptional = editorialRepository.findById(id);

            if(editorialOptional.isPresent()){
                Editorial editorial = editorialOptional.get();
                editorial.setAlta(!editorial.getAlta());
                editorialRepository.save(editorial);
            } else {
                throw new ExceptionBBDD("deleteByIdSoft");
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionBBDD(e.getMessage());
        }
    }

    @Override
    public List<Editorial> findAllByAlta() throws ExceptionBBDD {
        try {
            Optional<List<Editorial>> editorialesOptional = Optional.ofNullable(editorialRepository.findAllByAlta());
            return editorialesOptional.get();
        } catch (Exception e) {
            throw new ExceptionBBDD(e.getMessage());
        }
    }
}
