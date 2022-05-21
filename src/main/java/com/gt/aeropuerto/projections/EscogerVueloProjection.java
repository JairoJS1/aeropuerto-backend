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
public interface EscogerVueloProjection {

    public String getNumero_vuelo();
    public Date getHora_llegada();
    public Date getHora_salida();
    public Integer getDestino();
    public Integer getOrigen();
    public String getId_avion();
    public String getId_puerta();
    public Integer getId_escala();
    public Integer getEstado_vuelo();
    public String getAsientos();
    
    
    public String getDestinoDescripcion();
    public String getDestinoDescripcion2();
    public String getOrigenDescripcion();
    public String getPaisEscala();
    public String getCiudadEscala();
    
    public Integer getIdAerolinea();
    public String getNombreAerolinea();
}
