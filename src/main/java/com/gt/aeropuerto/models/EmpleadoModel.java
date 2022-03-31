
package com.gt.aeropuerto.models;

import java.util.Date;
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
@Table(name = "empleados", schema = "public")
public class EmpleadoModel implements java.io.Serializable{
    
    private Integer dpiEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Date fechaNacimiento;
    private Integer telefonoEmpleado;
    private String correoEmpleado;
    private Integer departamentoEmpleado;
    private Integer estadoEmpleado;
    private String numeroVuelo;

    public EmpleadoModel() {
    }

    public EmpleadoModel(Integer dpiEmpleado, String nombreEmpleado, String apellidoEmpleado, Date fechaNacimiento, Integer telefonoEmpleado, String correoEmpleado, Integer departamentoEmpleado, Integer estadoEmpleado, String numeroVuelo) {
        this.dpiEmpleado = dpiEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoEmpleado = telefonoEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.departamentoEmpleado = departamentoEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        this.numeroVuelo = numeroVuelo;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dpi", unique = true, nullable = false)
    public Integer getDpiEmpleado() {
        return dpiEmpleado;
    }

    public void setDpiEmpleado(Integer dpiEmpleado) {
        this.dpiEmpleado = dpiEmpleado;
    }

    @Column(name = "nombre_empleado", nullable = false)
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Column(name = "apellido_empleado", nullable = false)
    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    @Column(name = "fecha_nacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name = "telefono_empleado")
    public Integer getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(Integer telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    @Column(name = "correo_empleado")
    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    @Column(name = "departamento")
    public Integer getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    public void setDepartamentoEmpleado(Integer departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    @Column(name = "estado_empleado")
    public Integer getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(Integer estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    @Column(name = "numero_vuelo")
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }
    
    
}
