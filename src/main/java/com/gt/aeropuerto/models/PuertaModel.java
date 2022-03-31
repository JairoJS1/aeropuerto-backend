package com.gt.aeropuerto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

/**
 *
 * @author JairoJS
 */
@Entity
@Builder
@Table(name = "puertas", schema = "public")
public class PuertaModel implements java.io.Serializable {

    private String idPuerta;
    private Integer numeroPuerta;
    private Integer estadoPuerta;

    public PuertaModel() {
    }

    public PuertaModel(String idPuerta, Integer numeroPuerta, Integer estadoPuerta) {
        this.idPuerta = idPuerta;
        this.numeroPuerta = numeroPuerta;
        this.estadoPuerta = estadoPuerta;
    }

    @Id
    @Column(name = "id_puerta", unique = true, nullable = false)
    public String getIdPuerta() {
        return idPuerta;
    }

    public void setIdPuerta(String idPuerta) {
        this.idPuerta = idPuerta;
    }

    @Column(name = "numeropuerta", nullable = false)
    public Integer getNumeroPuerta() {
        return numeroPuerta;
    }

    public void setNumeroPuerta(Integer numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    @Column(name = "estado_puertas")
    public Integer getEstadoPuerta() {
        return estadoPuerta;
    }

    public void setEstadoPuerta(Integer estadoPuerta) {
        this.estadoPuerta = estadoPuerta;
    }

}
