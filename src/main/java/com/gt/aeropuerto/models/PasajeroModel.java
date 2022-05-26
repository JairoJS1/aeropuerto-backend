
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
@Table(name = "pasajero", schema = "public")
public class PasajeroModel implements java.io.Serializable{
    
    private Integer idPasajero;
    private String numeroPasaporte;
    private String nombrePasajero;
    private String apellidoPasajero;

    public PasajeroModel() {
    }

    public PasajeroModel(Integer idPasajero, String numeroPasaporte, String nombrePasajero, String apellidoPasajero) {
        this.idPasajero = idPasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.nombrePasajero = nombrePasajero;
        this.apellidoPasajero = apellidoPasajero;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_pasajero", unique = true, nullable = false)
    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    @Column(name = "numero_pasaporte", nullable = false)
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    @Column(name = "nombre_pasajero", nullable = false)
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    @Column(name = "apellido_pasajero", nullable = false)
    public String getApellidoPasajero() {
        return apellidoPasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        this.apellidoPasajero = apellidoPasajero;
    }

    public PasajeroModel orElse(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
