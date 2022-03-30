package com.gt.aeropuerto.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "cat_catalogo", schema = "public")
public class CatCatalogoModel implements java.io.Serializable {

    private Integer codigo;
    private String nombre;
    private Integer estado;
    private String usuarioAgrega;
    private Date fechaAgrega;
    private String usuarioModifica;
    private Date fechaModifica;

    public CatCatalogoModel() {
    }

    public CatCatalogoModel(Integer codigo, String nombre, Integer estado, String usuarioAgrega, Date fechaAgrega, String usuarioModifica, Date fechaModifica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarioAgrega = usuarioAgrega;
        this.fechaAgrega = fechaAgrega;
        this.usuarioModifica = usuarioModifica;
        this.fechaModifica = fechaModifica;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "codigo", unique = true, nullable = false)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Column(name = "usuario_agrega")
    public String getUsuarioAgrega() {
        return usuarioAgrega;
    }

    public void setUsuarioAgrega(String usuarioAgrega) {
        this.usuarioAgrega = usuarioAgrega;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_agrega")
    public Date getfechaAgrega() {
        return fechaAgrega;
    }

    public void setfechaAgrega(Date fechaAgrega) {
        this.fechaAgrega = fechaAgrega;
    }

    @Column(name = "usuario_modifica")
    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modifica")
    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

}
