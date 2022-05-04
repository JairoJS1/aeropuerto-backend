/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.projections.PuertasProjection;
import com.gt.aeropuerto.services.PuertasServices;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author denis
 */
@RestController
@Slf4j
public class PuertasController {

    final static Logger LOG = LoggerFactory.getLogger(EscalasController.class);

    @Autowired
    PuertasServices puertasServices;

    @GetMapping(value = "/puertas/obtener/todas")
    public List<PuertasProjection> obtenerAllPuertas() {
        return puertasServices.obtenerAllPuertas();
    }

    @GetMapping(value = "/puertas/obtener/{idPuerta}")
    public PuertasProjection obtenerPuertaById(@Valid @RequestParam String idPuerta) {
        return puertasServices.obtenerPuertaById(idPuerta);
    }

}
