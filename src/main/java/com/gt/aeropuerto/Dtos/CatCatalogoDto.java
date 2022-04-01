
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
public class CatCatalogoDto implements Serializable{
   
    private String nombre;
    private Integer estado;
    private String usuarioAgrega;
    private Date fechaAgrega;

}
