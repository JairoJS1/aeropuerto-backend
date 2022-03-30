
package com.gt.aeropuerto.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;
/**
 *
 * @author JairoJS
 */
@Entity
@Builder
@Table(name = "boleto", schema = "public")
public class BoletoModel implements java.io.Serializable{
    
    private String numeroBoleto;
    private Date fechaCreacion;
    private String numeroAsiento;
    private Integer estadoBoleto;
    private Boolean presentacion;
    private Integer idPasajero;
    private String numeroVuelo;

    public BoletoModel() {
    }

    public BoletoModel(String numeroBoleto, Date fechaCreacion, String numeroAsiento, Integer estadoBoleto, Boolean presentacion, Integer idPasajero, String numeroVuelo) {
        this.numeroBoleto = numeroBoleto;
        this.fechaCreacion = fechaCreacion;
        this.numeroAsiento = numeroAsiento;
        this.estadoBoleto = estadoBoleto;
        this.presentacion = presentacion;
        this.idPasajero = idPasajero;
        this.numeroVuelo = numeroVuelo;
    }

    @Id
    @Column(name = "numero_boleto",  unique = true, nullable = false)
    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Column(name = "numero_asiento", nullable = false)
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Column(name = "estado_boleto")
    public Integer getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(Integer estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

    @Column(name = "presentacion")
    public Boolean getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Boolean presentacion) {
        this.presentacion = presentacion;
    }

    @Column(name = "id_pasajero")
    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    @Column(name = "numero_vuelo")
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }
    
    
    
}
