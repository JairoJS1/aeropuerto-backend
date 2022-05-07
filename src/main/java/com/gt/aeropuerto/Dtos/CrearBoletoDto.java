/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Dtos;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author JairoJS
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class CrearBoletoDto implements Serializable {

    private String numeroPasaporte;
    private String nombrePasajero;
    private String apellidoPasajero;
    
    private Date fechaCreacion;
    private String numeroAsiento;
    private String numeroVuelo;
    
    private String asientos;

}
