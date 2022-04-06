/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarAerolineaDto;
import com.gt.aeropuerto.models.AerolineasModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import com.gt.aeropuerto.services.AerolineaServices;
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
 * @author denis
 */
@RestController
@Slf4j
public class AerolineasController {

    final static Logger LOG = LoggerFactory.getLogger(AerolineasController.class);

    @Autowired
    AerolineaServices aerolineaServices;

    @PostMapping(value = "/aerolineas/crear")
    public Boolean crearAerolinea(@Valid @RequestBody AerolineasModel aerolinea) {
        log.info("Creando una aerolinea");
        try {
            return aerolineaServices.crearAerolinea(aerolinea);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @PutMapping(value = "/aerolineas/actualizar/{idAerolinea}")
    public Boolean actualizarAerolinea(@Valid @RequestParam Integer idAerolinea, @RequestBody ActualizarAerolineaDto dto) {
        log.info("Actulizando una aerolinea");
        try {
            return aerolineaServices.actualizarAerolinea(idAerolinea, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @GetMapping(value = "/aerolinea/obtener/todas")
    public List<AerolineasProjection> obtenerAllAerolineas() {
        return aerolineaServices.obtnerAllAerolinea();
    }

    @GetMapping(value = "/aerolinea/obtener/{idAerolinea}")
    public AerolineasProjection obtenerAllAerolineas(@Valid @RequestParam Integer isAerolinea) {
        return aerolineaServices.obtnerAerolineaById(isAerolinea);
    }
}
