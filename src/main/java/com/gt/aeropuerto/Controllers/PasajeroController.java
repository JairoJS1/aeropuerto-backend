/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.models.PasajeroModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import com.gt.aeropuerto.services.PasajeroServices;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JairoJS
 */
@RestController
@Slf4j
public class PasajeroController {

    final static Logger LOG = LoggerFactory.getLogger(AerolineasController.class);

    @Autowired
    PasajeroServices pasajeroServices;
    
     @GetMapping(value = "/pasajero/obtener/{numeroPasaporte}")
    public PasajeroModel obtenerPasajero(@Valid @PathVariable String numeroPasaporte) {
        return pasajeroServices.obtenerPasajero(numeroPasaporte);
    }
}
