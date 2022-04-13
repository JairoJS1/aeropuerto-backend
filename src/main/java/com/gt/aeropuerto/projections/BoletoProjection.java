/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.projections;

import java.util.Date;

/**
 *
 * @author JairoJS
 */
public interface BoletoProjection {

    public Integer getId_boleto();
    public String getNumero_boleto();
    public Date getFecha_creacion();
    public String getNumero_asiento();
    public Integer getEstado_boleto();
    public Boolean getPresentacion();
    public Integer getId_pasajero();
    public String getNumero_vuelo();
    public String getDetalleEstado();
    public String getNombre_pasajero();
    public String getApellido_pasajero();
    
}
