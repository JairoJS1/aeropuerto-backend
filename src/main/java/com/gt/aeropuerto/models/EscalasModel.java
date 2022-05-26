package com.gt.aeropuerto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

/**
 *
 * @author JairoJS
 */
@Entity
@Builder
@Table(name = "escalas", schema = "public")
public class EscalasModel implements java.io.Serializable {

    private Integer idEscala;
    private String paisEscala;
    private String ciudadEscala;
    private Integer estadoEscalas;

    public EscalasModel() {
    }

    public EscalasModel(Integer idEscala, String paisEscala, String ciudadEscala, Integer estadoEscalas) {
        this.idEscala = idEscala;
        this.paisEscala = paisEscala;
        this.ciudadEscala = ciudadEscala;
        this.estadoEscalas = estadoEscalas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_escala", unique = true, nullable = false)
    public Integer getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(Integer idEscala) {
        this.idEscala = idEscala;
    }

    @Column(name = "pais", nullable = false)
    public String getPaisEscala() {
        return paisEscala;
    }

    public void setPaisEscala(String paisEscala) {
        this.paisEscala = paisEscala;
    }

    @Column(name = "ciudad", nullable = false)
    public String getCiudadEscala() {
        return ciudadEscala;
    }

    public void setCiudadEscala(String ciudadEscala) {
        this.ciudadEscala = ciudadEscala;
    }

    @Column(name = "estado_escalas", nullable = false)
    public Integer getEstadoEscalas() {
        return estadoEscalas;
    }

    public void setEstadoEscalas(Integer estadoEscalas) {
        this.estadoEscalas = estadoEscalas;
    }

}
