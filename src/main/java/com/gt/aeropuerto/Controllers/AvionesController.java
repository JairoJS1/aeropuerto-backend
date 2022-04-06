/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarAvionDto;
import com.gt.aeropuerto.models.AvionesModel;
import com.gt.aeropuerto.projections.AvionesProjections;
import com.gt.aeropuerto.services.AvionesServices;
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
public class AvionesController {

    final static Logger LOG = LoggerFactory.getLogger(CatalogoController.class);

    @Autowired
    AvionesServices avionesServices;

    @PostMapping(value = "/aviones/crear")
    public Boolean crearAviones(@Valid @RequestBody AvionesModel aviones) {
        log.info("Creando un avión");
        try {
            return avionesServices.crearAvion(aviones);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @PutMapping(value = "/aviones/actulizar/{idAvion}")
    public Boolean actualizarAvion(@Valid @RequestParam String idAvion, @RequestBody ActualizarAvionDto dto) {
        log.info("Actulizando un avion");
        try {
            return avionesServices.actulizarAvion(idAvion, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @GetMapping(value = "/aviones/obtener/todos")
    public List<AvionesProjections> obtenerAllAviones() {
        return avionesServices.obtnerAllAviones();
    }

    @GetMapping(value = "/aviones/obtener/id/{idAvion}")
    public AvionesProjections obtenerAllAviones(@Valid @RequestParam String idAvion) {
        return avionesServices.obtnerAvionesById(idAvion);
    }
}
