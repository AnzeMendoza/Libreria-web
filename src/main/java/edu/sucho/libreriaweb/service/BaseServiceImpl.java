package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.exception.ExceptionBBDD;
import edu.sucho.libreriaweb.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl<E, ID> implements BaseService<E, ID>{

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public E save(E entity) throws ExceptionBBDD {
        try {
            entity = baseRepository.save(entity);
        } catch (Exception e){
            log.info(">>> save <<<");
            throw new ExceptionBBDD(e.getMessage());
        }
        return entity;
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws ExceptionBBDD {
        Optional<E> entityOptional;
        E entityUpdate;
        try {
            entityOptional = baseRepository.findById(id);
            entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
        } catch (Exception e){
            log.info(">>> update <<<");
            throw new ExceptionBBDD(e.getMessage());
        }
        return entityUpdate;
    }

    @Override
    @Transactional
    public Boolean delete(ID id) throws ExceptionBBDD {
        try {
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
            } else {
                throw new ExceptionBBDD("");
            }
        } catch (Exception e){
            log.info(">>> delete <<<");
            throw new ExceptionBBDD(e.getMessage());
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(ID id) throws ExceptionBBDD {
        Optional<E> entityEncontrada;
        try {
            entityEncontrada = baseRepository.findById(id);
        } catch (Exception e){
            log.info(">>> findById <<<");
            throw new ExceptionBBDD(e.getMessage());
        }
        return entityEncontrada.get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() throws ExceptionBBDD {
        List<E> entities;
        try {
            entities = baseRepository.findAll();
        } catch (Exception e){
            log.info(">>> findAll <<<");
            throw new ExceptionBBDD(e.getMessage());
        }
        return entities;
    }
}
