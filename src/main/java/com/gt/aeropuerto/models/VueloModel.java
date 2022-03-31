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
@Table(name = "vuelo", schema = "public")
public class VueloModel implements java.io.Serializable {

    private String numeroVuelo;
    private Date horaLlegada;
    private Date horaSalida;
    private Integer destinoVuelo;
    private Integer origenVuelo;
    private String idAvion;
    private String idPuerta;
    private Integer idEscala;
    private Integer estadoVuelo;

    public VueloModel() {
    }

    public VueloModel(String numeroVuelo, Date horaLlegada, Date horaSalida, Integer destinoVuelo, Integer origenVuelo, String idAvion, String idPuerta, Integer idEscala, Integer estadoVuelo) {
        this.numeroVuelo = numeroVuelo;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.destinoVuelo = destinoVuelo;
        this.origenVuelo = origenVuelo;
        this.idAvion = idAvion;
        this.idPuerta = idPuerta;
        this.idEscala = idEscala;
        this.estadoVuelo = estadoVuelo;
    }

    @Id
    @Column(name = "numero_vuelo", unique = true, nullable = false)
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora_llegada")
    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora_salida")
    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(name = "destino")
    public Integer getDestinoVuelo() {
        return destinoVuelo;
    }

    public void setDestinoVuelo(Integer destinoVuelo) {
        this.destinoVuelo = destinoVuelo;
    }

    @Column(name = "origen")
    public Integer getOrigenVuelo() {
        return origenVuelo;
    }

    public void setOrigenVuelo(Integer origenVuelo) {
        this.origenVuelo = origenVuelo;
    }

    @Column(name = "id_avion", nullable = false)
    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    @Column(name = "id_puerta")
    public String getIdPuerta() {
        return idPuerta;
    }

    public void setIdPuerta(String idPuerta) {
        this.idPuerta = idPuerta;
    }

    @Column(name = "id_escala")
    public Integer getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(Integer idEscala) {
        this.idEscala = idEscala;
    }

    @Column(name = "estado_vuelo")
    public Integer getEstadoVuelo() {
        return estadoVuelo;
    }

    public void setEstadoVuelo(Integer estadoVuelo) {
        this.estadoVuelo = estadoVuelo;
    }

}
