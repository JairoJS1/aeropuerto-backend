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
@Table(name = "aerolineas", schema = "public")
public class AerolineasModel implements java.io.Serializable{
    
    private Integer idAerolinea;
    private String nombreAerolinea;
    private Integer telefonoAerolinea;
    private String correoAerolinea;
    private String direccionAerolinea;
    private Integer estadoAerolinea;

    public AerolineasModel() {
    }

    public AerolineasModel(Integer idAerolinea, String nombreAerolinea, Integer telefonoAerolinea, String correoAerolinea, String direccionAerolinea, Integer estadoAerolinea) {
        this.idAerolinea = idAerolinea;
        this.nombreAerolinea = nombreAerolinea;
        this.telefonoAerolinea = telefonoAerolinea;
        this.correoAerolinea = correoAerolinea;
        this.direccionAerolinea = direccionAerolinea;
        this.estadoAerolinea = estadoAerolinea;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_aerolinea", unique = true, nullable = false)
    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    
    @Column(name = "nombre_aerolinea",  nullable = false)
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    @Column(name = "telefono_aerolinea")
    public Integer getTelefonoAerolinea() {
        return telefonoAerolinea;
    }

    public void setTelefonoAerolinea(Integer telefonoAerolinea) {
        this.telefonoAerolinea = telefonoAerolinea;
    }

    @Column(name = "correo_aerolinea")
    public String getCorreoAerolinea() {
        return correoAerolinea;
    }

    public void setCorreoAerolinea(String correoAerolinea) {
        this.correoAerolinea = correoAerolinea;
    }

    @Column(name = "direccion_aerolinea")
    public String getDireccionAerolinea() {
        return direccionAerolinea;
    }

    public void setDireccionAerolinea(String direccionAerolinea) {
        this.direccionAerolinea = direccionAerolinea;
    }

    @Column(name = "estado_aerolinea", nullable = false)
    public Integer getEstadoAerolinea() {
        return estadoAerolinea;
    }

    public void setEstadoAerolinea(Integer estadoAerolinea) {
        this.estadoAerolinea = estadoAerolinea;
    }

}
