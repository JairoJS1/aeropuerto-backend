/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ActualizarEmpleadoDto;
import com.gt.aeropuerto.models.EmpleadoModel;
import com.gt.aeropuerto.projections.EmpleadosProjection;
import com.gt.aeropuerto.services.EmpleadoServices;
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
 * @author denis
 */
@RestController
@Slf4j
public class EmpleadosController {

    final static Logger LOG = LoggerFactory.getLogger(EmpleadosController.class);

    @Autowired
    EmpleadoServices empleadoServices;

    @PostMapping(value = "/empleados/crear")
    public Boolean crearEmpleado(@Valid @RequestBody EmpleadoModel empleado) {
        log.info("Creando un empledo");
        try {
            return empleadoServices.crearEmpleado(empleado);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @PutMapping(value = "/empleados/actualizar/{dpiEmpleado}")
    public Boolean actualizarEmpleado(@Valid @PathVariable String dpiEmpleado, @RequestBody ActualizarEmpleadoDto dto) {
        log.info("Actulizando un empleado");
        try {
            return empleadoServices.actualizarEmpleado(dpiEmpleado, dto);
        } catch (Exception e) {
            LOG.error("Error: " + e);
            return false;
        }
    }

    @GetMapping(value = "/empleados/obtener/todos")
    public List<EmpleadosProjection> obtenerAllEmpleados() {
        return empleadoServices.ObtenerAllEmpleados();
    }

    @GetMapping(value = "/empleados/obtener/{dpi}")
    public EmpleadosProjection obtenerAllAerolineas(@Valid @RequestParam String dpiEmpleado) {
        return empleadoServices.ObtenerEmpleadoByDPI(dpiEmpleado);
    }
}
