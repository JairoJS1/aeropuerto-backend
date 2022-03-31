package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.CatEstadoCatalogoDto;
import com.gt.aeropuerto.models.CatEstadoCatalogo;
import com.gt.aeropuerto.repositories.CatEstadoCatalogoRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
@Transactional
public class CatEstadoCatalogoServices {

    @Autowired
    CatEstadoCatalogoRepository catEstadoCatalogoRepository;

    @Transactional(rollbackFor = {Exception.class})
    public CatEstadoCatalogo crearEstadoCatalogo(CatEstadoCatalogoDto dto) {

        try {
            System.out.println("prueba: " + dto.getNombre());
            final CatEstadoCatalogo estadoCatalogo = catEstadoCatalogoRepository.save(
                    CatEstadoCatalogo.builder()
                            .nombre(dto.getNombre())
                            .usuarioAgrega(dto.getUsuarioAgrega())
                            .fechaAgrega(dto.getFechaAgrega())
                            .build()
            );
            return estadoCatalogo;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CatEstadoCatalogo> obtenerEstadoCatalogos() {

        return (List<CatEstadoCatalogo>) catEstadoCatalogoRepository.findAll();

    }
}
