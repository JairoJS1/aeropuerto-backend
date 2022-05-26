package com.gt.aeropuerto.Dtos;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author JairoJS
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class CatDatoDto implements Serializable {

    private Integer codigoCatalogo;
    private String nombre;
    private String descripcion;
    private Integer estado;
    private String usuarioAgrega;
    private Date fechaAgrega;
}
