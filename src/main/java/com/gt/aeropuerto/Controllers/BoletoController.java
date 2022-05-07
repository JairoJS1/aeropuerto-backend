/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarBoletoDto;
import com.gt.aeropuerto.Dtos.CrearBoletoDto;
import com.gt.aeropuerto.Dtos.RespuestaBoletoDto;
import com.gt.aeropuerto.projections.BoletoCrearProjection;
import com.gt.aeropuerto.projections.BoletoProjection;
import com.gt.aeropuerto.services.BoletoServices;
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
public class BoletoController {

    final static Logger LOG = LoggerFactory.getLogger(BoletoController.class);

    @Autowired
    BoletoServices boletoServices;

    @PostMapping(value = "/boleto/crear")
    public RespuestaBoletoDto crearBoleto(@Valid @RequestBody CrearBoletoDto boleto) {
        log.info("Creando un vuelo");

        return boletoServices.crearBoleto(boleto);

    }

    @PutMapping(value = "/boleto/actualizar/{idBoleto}")
    public Boolean actualizarBoleto(@Valid @RequestParam Integer idBoleto, @RequestBody ActualizarBoletoDto dto) {
        log.info("Actulizando una aerolinea");
        try {
            return boletoServices.actualizarBoleto(idBoleto, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @GetMapping(value = "/boleto/obtener/todo")
    public List<BoletoProjection> obtenerBoletos() {
        log.info("consultado...");
        try {
            return boletoServices.obtenerBoletos();
        } catch (Exception e) {
            log.info("no exiten datos para mostrar", "404");
            return null;
        }
    }

    @GetMapping(value = "/boleto/obtener/{idBoleto}")
    public BoletoProjection obtenerBoletos(@Valid @RequestParam Integer idBoleto) {
        log.info("consultado...");
        BoletoProjection boleto;

        try {
            return boleto = boletoServices.obtenerBoletoById(idBoleto);
        } catch (Exception e) {
            boleto = null;
            LOG.debug("Error" + e);
        }
        return boleto;
    }
    
     @GetMapping(value = "/boleto/info/{idBoleto}")
    public BoletoCrearProjection obtenerInfo(@Valid @PathVariable Integer idBoleto) {
        log.info("consultado...");
        BoletoCrearProjection boleto;

        try {
            return boleto = boletoServices.obteneInfo(idBoleto);
        } catch (Exception e) {
            boleto = null;
            LOG.debug("Error" + e);
        }
        return boleto;
    }
}
