/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.PasajeroModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface PasajeroRepository extends CrudRepository<PasajeroModel, Integer> {

    @Query(value = "select p.id_pasajero, p.numero_pasaporte,"
            + " p.nombre_pasajero, p.apellido_pasajero"
            + " from public.pasajero p"
            + " where p.numero_pasaporte = :numeroPasaportes",
            nativeQuery = true
    )
    public PasajeroModel obtenerPasajero(@Param("numeroPasaportes") String numeroPasaportes);
}
