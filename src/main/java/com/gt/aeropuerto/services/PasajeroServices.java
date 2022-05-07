/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.models.PasajeroModel;
import com.gt.aeropuerto.repositories.PasajeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
public class PasajeroServices {
    @Autowired
    PasajeroRepository pasajeroRepository;
    
    public PasajeroModel obtenerPasajero(String numeroPasaporte){
        return pasajeroRepository.obtenerPasajero(numeroPasaporte);
    }
}
