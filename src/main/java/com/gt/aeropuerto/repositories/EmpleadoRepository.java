/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.EmpleadoModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author denis
 */
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, String> {
    
}
