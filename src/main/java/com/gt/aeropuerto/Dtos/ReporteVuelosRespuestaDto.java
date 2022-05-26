/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Dtos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author JairoJS
 */
@Entity
public class ReporteVuelosRespuestaDto implements Serializable {

    private Integer id;
    private String numero_vuelo;
    private Date hora_llegada;
    private Date hora_salida;
    private String destino;
    private String origen;
    private String escala;
    private String estado_vuelo;

    public ReporteVuelosRespuestaDto() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_vuelo() {
        return numero_vuelo;
    }

    public void setNumero_vuelo(String numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Date hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public String getEstado_vuelo() {
        return estado_vuelo;
    }

    public void setEstado_vuelo(String estado_vuelo) {
        this.estado_vuelo = estado_vuelo;
    }

}
