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
public interface BoletoVueloProjection {
    public String getNombrePasajero();
    public String getApellidoPasajero();
    public String getNumeroPasaporte();
    public String getNumeroVuelo();
    public String getNombreAerolinea();
    public Integer getIdAerolinea();
    public String getOrigen();
    public String getDestino();
    public String getDescDestino();
    public Date getHoraDespegue();
    public Date getHoraAterrizaje();
    public Integer getIdEstadoVuelo();
    public String getEstadoVuelo();        
    public String getNumeroBoleto();
    public Integer getIdEscala();
    public String getEscalaCiudad();
    public String getEscalaPais();
    public Integer getIdBoleto();
}
