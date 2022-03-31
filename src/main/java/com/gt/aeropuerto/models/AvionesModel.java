
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
@Table(name = "aviones", schema = "public")
public class AvionesModel implements java.io.Serializable {
    
    private String idAvion;
    private String modeloAvion;
    private String anioAvion;
    private Integer estadoAvion;
    private Integer idAerolinea;

    public AvionesModel() {
    }

    public AvionesModel(String idAvion, String modeloAvion, String anioAvion, Integer estadoAvion, Integer idAerolinea) {
        this.idAvion = idAvion;
        this.modeloAvion = modeloAvion;
        this.anioAvion = anioAvion;
        this.estadoAvion = estadoAvion;
        this.idAerolinea = idAerolinea;
    }

    @Id
    @Column(name = "id_avion", unique = true, nullable = false)
    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    @Column(name = "modelo", nullable = false)
    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }
    
    @Column(name = "anio", nullable = false)
    public String getAnioAvion() {
        return anioAvion;
    }

    public void setAnioAvion(String anioAvion) {
        this.anioAvion = anioAvion;
    }

    @Column(name = "estado_avion")
    public Integer getEstadoAvion() {
        return estadoAvion;
    }

    public void setEstadoAvion(Integer estadoAvion) {
        this.estadoAvion = estadoAvion;
    }

    @Column(name = "aerolinea")
    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
    
    
}
