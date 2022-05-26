/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author denis
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class ActualizarEmpleadoDto {

    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Date fechaNacimiento;
    private Integer telefonoEmpleado;
    private String correoEmpleado;
    private Integer departamentoEmpleado;
    private Integer estadoEmpleado;
    private String numeroVuelo;
}
