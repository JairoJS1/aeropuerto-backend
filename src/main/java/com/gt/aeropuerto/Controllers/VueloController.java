/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarVueloDto;
import com.gt.aeropuerto.models.VueloModel;
import com.gt.aeropuerto.projections.VuelosProjection;
import com.gt.aeropuerto.services.VueloService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class VueloController {

    final static Logger LOG = LoggerFactory.getLogger(VueloController.class);

    @Autowired
    VueloService vueloService;

    @PostMapping(value = "/vuelo/crear")
    public Boolean crearEscala(@Valid @RequestBody VueloModel vuelo) {
        log.info("Creando un vuelo");
        try {
            return vueloService.crearVuelo(vuelo);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @PutMapping(value = "/vuelo/actualizar/{numeroVuelo}")
    public Boolean actualizarEscala(@Valid @PathVariable String numeroVuelo, @RequestBody ActualizarVueloDto dto) {
        log.info("Actulizando un vuelo");
        try {
            return vueloService.actualizarVuelo(numeroVuelo, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @GetMapping(value = "/vuelo/obtener/todas")
    public List<VuelosProjection> obtenerAllEscalas() {
        return vueloService.obtnerAllAerolinea();
    }

    @GetMapping(value = "/vuelo/obtener/{numeroVuelo}")
    public VuelosProjection obtenerAllAerolineas(@Valid @RequestParam String numeroVuelo) {
        return vueloService.obtnerAerolineaById(numeroVuelo);
    }
}
