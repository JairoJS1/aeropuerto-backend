/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarAerolineaDto;
import com.gt.aeropuerto.Dtos.EscalasDto;
import com.gt.aeropuerto.models.AerolineasModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import com.gt.aeropuerto.projections.EscalasProjection;
import com.gt.aeropuerto.services.AerolineaServices;
import com.gt.aeropuerto.services.EscalaServices;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JairoJS
 */
@RestController
@Slf4j
public class EscalasController {

    final static Logger LOG = LoggerFactory.getLogger(EscalasController.class);

    @Autowired
    EscalaServices escalaServices;

    @PostMapping(value = "/escala/crear")
    public Boolean crearEscala(@Valid @RequestBody EscalasDto escala) {
        log.info("Creando una aerolinea");
        try {
            return escalaServices.crearEscala(escala);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @PutMapping(value = "/escala/actualizar/{idEscala}")
    public Boolean actualizarEscala(@Valid @RequestParam Integer idEscala, @RequestBody EscalasDto dto) {
        log.info("Actulizando una aerolinea");
        try {
            return escalaServices.actualizarEscala(idEscala, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

     @GetMapping(value = "/escalas/obtener/todas")
    public List<EscalasProjection> obtenerAllEscalas() {
        return escalaServices.obtnerAllAerolinea();
    }

    @GetMapping(value = "/escalas/obtener/{idEscalas}")
    public EscalasProjection obtenerAllAerolineas(@Valid @RequestParam Integer idEscalas) {
        return escalaServices.obtnerAerolineaById(idEscalas);
    }
}
