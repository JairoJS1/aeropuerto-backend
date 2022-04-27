package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.CatCatalogoDto;
import com.gt.aeropuerto.Dtos.CatDatoDto;
import com.gt.aeropuerto.Dtos.CatEstadoCatalogoDto;
import com.gt.aeropuerto.models.CatCatalogoModel;
import com.gt.aeropuerto.models.CatDatoModel;
import com.gt.aeropuerto.models.CatEstadoCatalogo;
import com.gt.aeropuerto.repositories.CatCatalogoRepository;
import com.gt.aeropuerto.repositories.CatDatoRepository;
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
public class CatalogoServices {

    @Autowired
    CatEstadoCatalogoRepository catEstadoCatalogoRepository;

    @Autowired
    CatCatalogoRepository catCatalogoRepository;

    @Autowired
    CatDatoRepository catDatoRepository;

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

    /*
    * Servicios para CatCatalogo
     */
    @Transactional(rollbackFor = {Exception.class})
    public CatCatalogoModel crearCatalogo(CatCatalogoDto dto) {

        try {

            final CatCatalogoModel catCatalogo = catCatalogoRepository.save(
                    CatCatalogoModel.builder()
                            .nombre(dto.getNombre())
                            .estado(dto.getEstado())
                            .usuarioAgrega(dto.getUsuarioAgrega())
                            .fechaAgrega(dto.getFechaAgrega())
                            .build()
            );
            return catCatalogo;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CatCatalogoModel> obtenerCatalogos() {
        return (List<CatCatalogoModel>) catCatalogoRepository.findAll();
    }

    public CatCatalogoModel obtenerCatalogosById(Integer codigo) {
        return catCatalogoRepository.findById(codigo).orElse(null);
    }

    /*
    * Servicios para CatDato
     */
    @Transactional(rollbackFor = {Exception.class})
    public CatDatoModel crearDatoCatalogo(CatDatoDto dto) {

        try {

            final CatDatoModel catCatalogo = catDatoRepository.save(
                    CatDatoModel.builder()
                            .nombre(dto.getNombre())
                            .descripcion(dto.getDescripcion())
                            .codigoCatalogo(dto.getCodigoCatalogo())
                            .estado(dto.getEstado())
                            .usuarioAgrega(dto.getUsuarioAgrega())
                            .fechaAgrega(dto.getFechaAgrega())
                            .build()
            );
            return catCatalogo;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CatDatoModel> obtenerCatalogosDato() {
        return (List<CatDatoModel>) catDatoRepository.findAll();
    }

    public CatDatoModel obtenerDatosById(Integer codigo) {
        return catDatoRepository.findById(codigo).orElse(null);
    }

    public List<CatDatoModel> getCatalogosPadre(int codigo) {
        log.info("Obteniendo catalogos desde el servicio");
        return catDatoRepository.findByCodigoCatalogo(codigo);
    }
    
    public List<CatDatoModel> getCatalogosAerolineas() {
        log.info("Obteniendo catalogos desde el servicio");
        return catDatoRepository.obtenerCatalogo();
    }

}
