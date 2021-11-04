package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.exception.ExceptionBBDD;
import edu.sucho.libreriaweb.model.Prestamo;
import edu.sucho.libreriaweb.repository.BaseRepository;
import edu.sucho.libreriaweb.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl extends BaseServiceImpl<Prestamo, Integer> implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(BaseRepository<Prestamo, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean deleteByIdSoft(int id) throws ExceptionBBDD {
        try {
            Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);

            if(prestamoOptional.isPresent()){
                Prestamo prestamo = prestamoOptional.get();
                prestamo.setAlta(!prestamo.getAlta());
                prestamoRepository.save(prestamo);
            } else {
                throw new ExceptionBBDD("deleteByIdSoft");
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionBBDD(e.getMessage());
        }
    }

    @Override
    public List<Prestamo> findAllByAlta() throws ExceptionBBDD {
        return null;
    }
}
