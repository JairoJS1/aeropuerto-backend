/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Dtos;

import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author JairoJS
 */
public class ReporteVuelosDto {

    private Date fechaSalida;

    public ReporteVuelosDto() {
    }

    public ReporteVuelosDto(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Column(name = "hora_llegada", table = "v")
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "ReporteVuelosDto{" + "fechaSalida=" + fechaSalida + '}';
    }

}
