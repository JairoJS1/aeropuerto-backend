/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ActualizarAvionDto;
import com.gt.aeropuerto.models.AvionesModel;
import com.gt.aeropuerto.projections.AvionesProjections;
import com.gt.aeropuerto.repositories.AvionesRepository;
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
public class AvionesServices {
    
    @Autowired
    AvionesRepository avionesRepository;
    
    @Transactional(rollbackFor = {Exception.class})
    public Boolean crearAvion(AvionesModel aviones) {
        
        try {
            final AvionesModel crearAvion = avionesRepository.save(
                    AvionesModel.builder()
                            .idAvion(aviones.getIdAvion())
                            .modeloAvion(aviones.getModeloAvion())
                            .anioAvion(aviones.getAnioAvion())
                            .estadoAvion(aviones.getEstadoAvion())
                            .idAerolinea(aviones.getIdAerolinea())
                            .build()
            );
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear avion: " + e);
            return false;
        }
        
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public Boolean actulizarAvion(String idAvion, ActualizarAvionDto dto) {
        log.debug("Consultado un avion");
        final AvionesModel aviones = avionesRepository.findById(idAvion).orElse(null);
        if (aviones != null) {
            aviones.setModeloAvion(dto.getModeloAvion());
            aviones.setAnioAvion(dto.getAnioAvion());
            aviones.setEstadoAvion(dto.getEstadoAvion());
            aviones.setIdAerolinea(dto.getIdAerolinea());
            return true;
        } else {
            log.info("No exite el avion indicado");
            return false;
        }
        
    }
    
    
    public List<AvionesProjections> obtnerAllAviones(){
        return avionesRepository.obtenerAllAviones();
    }
    
    
    public AvionesProjections obtnerAvionesById(String idAvion){
        return avionesRepository.obtenerAvionesById(idAvion);
    }
    
}
