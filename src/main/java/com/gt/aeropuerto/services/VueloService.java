/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ActualizarVueloDto;
import com.gt.aeropuerto.models.VueloModel;
import com.gt.aeropuerto.projections.VuelosProjection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gt.aeropuerto.repositories.VueloRepository;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
@Transactional
public class VueloService {
    
    @Autowired
    VueloRepository vueloInterface;
    
    @Transactional(rollbackFor = {Exception.class})
    public Boolean crearVuelo(VueloModel vuelo) {
        
        try {
            final VueloModel crearVuelo = vueloInterface.save(
                    VueloModel.builder()
                            .numeroVuelo(vuelo.getNumeroVuelo())
                            .horaLlegada(vuelo.getHoraLlegada())
                            .horaSalida(vuelo.getHoraSalida())
                            .destinoVuelo(vuelo.getDestinoVuelo())
                            .origenVuelo(vuelo.getOrigenVuelo())
                            .idAvion(vuelo.getIdAvion())
                            .idPuerta(vuelo.getIdPuerta())
                            .idEscala(vuelo.getIdEscala())
                            .estadoVuelo(vuelo.getEstadoVuelo())
                            .build()
            );
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear vuelo: " + e);
            return false;
        }
        
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public Boolean actualizarVuelo(String numeroVuelo, ActualizarVueloDto dto) {
        log.debug("Consultando vuelo");
        final VueloModel vuelo = vueloInterface.findById(numeroVuelo).orElse(null);
        if (vuelo != null) {
            vuelo.setHoraLlegada(dto.getHoraLlegada());
            vuelo.setHoraSalida(dto.getHoraSalida());
            vuelo.setDestinoVuelo(dto.getDestinoVuelo());
            vuelo.setOrigenVuelo(dto.getOrigenVuelo());
            vuelo.setIdAvion(dto.getIdAvion());
            vuelo.setIdPuerta(dto.getIdPuerta());
            vuelo.setIdEscala(dto.getIdEscala());
            vuelo.setEstadoVuelo(dto.getEstadoVuelo());
            return true;
        } else {
            log.info("No exite el vuelo indicado");
            return false;
        }
        
    }
    
    public List<VuelosProjection> obtnerAllAerolinea() {
        return vueloInterface.obtenerAllVuelo();
    }
    
    public VuelosProjection obtnerAerolineaById(String numeroVuelo) {
        return vueloInterface.obteneVueloById(numeroVuelo);
    }
    
    public List<VueloModel> obtenerVueloByOrigenAndDestino(Integer origen, Integer destino){
        return vueloInterface.obteneVueloByDestinoAndOrigen(origen, destino);
    }
}
