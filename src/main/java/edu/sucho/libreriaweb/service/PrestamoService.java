package edu.sucho.libreriaweb.service;

import edu.sucho.libreriaweb.exception.ExceptionBBDD;
import edu.sucho.libreriaweb.model.Prestamo;

import java.util.List;

public interface PrestamoService {
    boolean deleteByIdSoft(int id) throws ExceptionBBDD;

    List<Prestamo> findAllByAlta() throws ExceptionBBDD;
}
