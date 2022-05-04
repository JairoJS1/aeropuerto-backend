/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.projections.PuertasProjection;
import com.gt.aeropuerto.repositories.PuertasRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author denis
 */
@Service
@Slf4j
@Transactional
public class PuertasServices {

    @Autowired
    PuertasRepository puertasInterface;

    public List<PuertasProjection> obtenerAllPuertas() {
        return puertasInterface.obtenerAllPuertas();
    }

    public PuertasProjection obtenerPuertaById(String idPuerta) {
        return puertasInterface.obtenerPuertaById(idPuerta);
    }

}
