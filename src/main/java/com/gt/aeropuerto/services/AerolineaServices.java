/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ActualizarAerolineaDto;
import com.gt.aeropuerto.models.AerolineasModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import com.gt.aeropuerto.repositories.AerolineasRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author denis
 */
@Service
@Slf4j
@Transactional
public class AerolineaServices {

    @Autowired
    AerolineasRepository aerolineaRepository;

    @Transactional(rollbackFor = {Exception.class})
    public Boolean crearAerolinea(AerolineasModel aerolineas) {

        try {
            final AerolineasModel crearAerolinea = aerolineaRepository.save(
                    AerolineasModel.builder()
                            .idAerolinea(aerolineas.getIdAerolinea())
                            .nombreAerolinea(aerolineas.getNombreAerolinea())
                            .telefonoAerolinea(aerolineas.getTelefonoAerolinea())
                            .correoAerolinea(aerolineas.getCorreoAerolinea())
                            .direccionAerolinea(aerolineas.getDireccionAerolinea())
                            .estadoAerolinea(aerolineas.getEstadoAerolinea())
                            .build()
            );
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear aerolinea: " + e);
            return false;
        }

    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean actualizarAerolinea(Integer idAerolinea, ActualizarAerolineaDto dto) {
        log.debug("Consultando aerolinea");
        final AerolineasModel aerolineas = aerolineaRepository.findById(idAerolinea).orElse(null);
        if (aerolineas != null) {
            aerolineas.setNombreAerolinea(dto.getNombreAerolinea());
            aerolineas.setTelefonoAerolinea(dto.getTelefonoAerolinea());
            aerolineas.setCorreoAerolinea(dto.getCorreoAerolinea());
            aerolineas.setDireccionAerolinea(dto.getDireccionAerolinea());
            aerolineas.setEstadoAerolinea(dto.getEstadoAerolinea());
            return true;
        } else {
            log.info("No exite la aerolinea indicada");
            return false;
        }

    }
    
    public List<AerolineasProjection> obtnerAllAerolinea(){
        return aerolineaRepository.obtenerAllAerolineas();
    }
    
    public AerolineasProjection obtnerAerolineaById(Integer idAerolinea){
        return aerolineaRepository.obtenerAerolineaById(idAerolinea);
    }

}
