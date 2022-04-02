/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ActualizarAerolineaDto;
import com.gt.aeropuerto.Dtos.ActualizarEmpleadoDto;
import com.gt.aeropuerto.models.EmpleadoModel;
import com.gt.aeropuerto.repositories.EmpleadoRepository;
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
public class EmpleadoServices {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Transactional(rollbackFor = {Exception.class})
    public Boolean crearEmpleado(EmpleadoModel empleados) {

        try {
            final EmpleadoModel crearEmpleado = empleadoRepository.save(
                    EmpleadoModel.builder()
                            .dpiEmpleado(empleados.getDpiEmpleado())
                            .nombreEmpleado(empleados.getNombreEmpleado())
                            .apellidoEmpleado(empleados.getApellidoEmpleado())
                            .fechaNacimiento(empleados.getFechaNacimiento())
                            .telefonoEmpleado(empleados.getTelefonoEmpleado())
                            .correoEmpleado(empleados.getCorreoEmpleado())
                            .departamentoEmpleado(empleados.getDepartamentoEmpleado())
                            .estadoEmpleado(empleados.getEstadoEmpleado())
                            .build()
            );
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear empleado: " + e);
            return false;
        }

    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean actualizarEmpleado(String dpiEmpleado, ActualizarEmpleadoDto dto) {
        log.debug("Consultando empleado");
        final EmpleadoModel empleados = empleadoRepository.findById(dpiEmpleado).orElse(null);
        if (empleados != null) {
            empleados.setNombreEmpleado(dto.getNombreEmpleado());
            empleados.setApellidoEmpleado(dto.getApellidoEmpleado());
            empleados.setFechaNacimiento(dto.getFechaNacimiento());
            empleados.setTelefonoEmpleado(dto.getTelefonoEmpleado());
            empleados.setCorreoEmpleado(dto.getCorreoEmpleado());
            empleados.setDepartamentoEmpleado(dto.getDepartamentoEmpleado());
            empleados.setEstadoEmpleado(dto.getEstadoEmpleado());
            return true;
        } else {
            log.info("No exite el empleado indicado");
            return false;
        }

    }
}
