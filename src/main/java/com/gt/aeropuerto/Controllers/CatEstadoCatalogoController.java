/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.CatEstadoCatalogoDto;
import com.gt.aeropuerto.models.CatEstadoCatalogo;
import com.gt.aeropuerto.services.CatEstadoCatalogoServices;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping; 

/**
 *
 * @author JairoJS
 */
@RestController
@Slf4j
public class CatEstadoCatalogoController {

    @Autowired
    CatEstadoCatalogoServices catEstadoCatalogoServices;

    @PostMapping(value = "/catalogo/estado/crear")
    public CatEstadoCatalogo crearCatalogoEstado(@RequestBody CatEstadoCatalogoDto catalogo) {
        log.info("Crea un catalogo de estado");

        return catEstadoCatalogoServices.crearEstadoCatalogo(catalogo);
    }
    
    @GetMapping(value = "/catalogo/obtener/todos")
    public List<CatEstadoCatalogo> obtenerCatalogoEstado(){
        return catEstadoCatalogoServices.obtenerEstadoCatalogos();
    }
}
