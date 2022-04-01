/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.CatCatalogoDto;
import com.gt.aeropuerto.Dtos.CatDatoDto;
import com.gt.aeropuerto.Dtos.CatEstadoCatalogoDto;
import com.gt.aeropuerto.models.CatCatalogoModel;
import com.gt.aeropuerto.models.CatDatoModel;
import com.gt.aeropuerto.models.CatEstadoCatalogo;
import com.gt.aeropuerto.services.CatalogoServices;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author JairoJS
 */
@RestController
@Slf4j
public class CatalogoController {

    final static Logger LOG = LoggerFactory.getLogger(CatalogoController.class);

    @Autowired
    CatalogoServices catEstadoCatalogoServices;

    /*
    *Metodos para la tabla CatCatalogoEstado
     */
    @PostMapping(value = "/catalogo/estado/crear")
    public CatEstadoCatalogo crearCatalogoEstado(@RequestBody CatEstadoCatalogoDto catalogo) {
        log.info("Crea un catalogo de estado");

        return catEstadoCatalogoServices.crearEstadoCatalogo(catalogo);
    }

    @GetMapping(value = "/catalogo/obtener/estados")
    public List<CatEstadoCatalogo> obtenerCatalogoEstado() {
        return catEstadoCatalogoServices.obtenerEstadoCatalogos();
    }

    /*
    *Metodos para la tabla CatCatalogo
     */
    @PostMapping(value = "/catCatalogo/crear")
    public CatCatalogoModel crearCatalogo(@RequestBody CatCatalogoDto catalogo) {
        log.info("Crea un catalogo de estado");

        return catEstadoCatalogoServices.crearCatalogo(catalogo);
    }

    @GetMapping(value = "/catCatalogo/obtener")
    public List<CatCatalogoModel> obtenerCatalogo() {
        return catEstadoCatalogoServices.obtenerCatalogos();
    }

    @GetMapping(value = "/catCatalogo/obtener/{codigo}")
    public CatCatalogoModel obtenerCatalogoById(@Valid @PathVariable Integer codigo) {
        CatCatalogoModel catalogo;
        try {
            catalogo = catEstadoCatalogoServices.obtenerCatalogosById(codigo);

        } catch (Exception e) {
            catalogo = null;
            LOG.error("Error: " + e);
        }

        return catalogo;
    }

    /*
    *Metodos para la tabla CatDato
     */
    
     @PostMapping(value = "/catDato/crear")
    public CatDatoModel crearDatoCatalogo(@RequestBody CatDatoDto catalogo) {
        log.info("Crea un catalogo de estado");

        return catEstadoCatalogoServices.crearDatoCatalogo(catalogo);
    }

    @GetMapping(value = "/catDatoCatalogo/obtener")
    public List<CatDatoModel> obtenerDatoCatalogo() {
        return catEstadoCatalogoServices.obtenerCatalogosDato();
    }

    @GetMapping(value = "/catDatoCatalogo/obtener/{codigo}")
    public CatDatoModel obtenerDatoCatalogoById(@Valid @PathVariable Integer codigo) {
        CatDatoModel catalogo;
        try {
            catalogo = catEstadoCatalogoServices.obtenerDatosById(codigo);

        } catch (Exception e) {
            catalogo = null;
            LOG.error("Error: " + e);
        }

        return catalogo;
    }
}
