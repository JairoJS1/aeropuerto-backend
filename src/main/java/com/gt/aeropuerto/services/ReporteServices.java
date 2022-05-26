/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ReporteVuelosDto;
import com.gt.aeropuerto.Dtos.ReporteVuelosRespuestaDto;
import com.gt.aeropuerto.repositories.GeneralRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JairoJS
 */
@Service
public class ReporteServices {
    
    @Autowired
    GeneralRepository generalRepository;
    
    final static Logger LOG = LoggerFactory.getLogger(ReporteServices.class);
    
     public List<ReporteVuelosRespuestaDto> obtenerReporteServicios(ReporteVuelosDto parametros) {
        try {
            List<ReporteVuelosRespuestaDto> resultado = this.generalRepository.obtenerReporteServicios(parametros);

            if (resultado.isEmpty()) {
                return null;
            } else {
                return resultado;
            }
        } catch (Exception e) {
            LOG.error("Error en obtenerReporteEventos: ", e);
            return null;
        }
    }
}
