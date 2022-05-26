/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.projections;

import java.util.Date;

/**
 *
 * @author denis
 */
public interface EmpleadosProjection {

    public String getDpi();
    public String getNombre_empleado();
    public String getApellido_empleado();
    public Date getFecha_nacimiento();
    public Integer getTelefono_empleado();
    public String getCorreo_empleado();
    public Integer getDepartamento();
    public Integer getEstado_empleado();
    public String getNumero_vuelo();
    public String getDetalleEmpleado();
    public String getDetalleEstado();
}
