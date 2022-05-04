/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.PuertaModel;
import com.gt.aeropuerto.projections.EscalasProjection;
import com.gt.aeropuerto.projections.PuertasProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author denis
 */
public interface PuertasRepository extends CrudRepository<PuertaModel, String> {

    @Query(value = "select e.*,  cd.nombre as \"detalleEstadoPuerta\" \n"
            + "from public.puertas e\n"
            + "inner join public.cat_dato cd on e.estado_puertas = cd.codigo",
            nativeQuery = true)
    public List<PuertasProjection> obtenerAllPuertas();

    @Query(value = "select e.*,  cd.nombre as \"detalleEstadoPuerta\" \n"
            + "from public.puertas e\n"
            + "inner join public.cat_dato cd on e.estado_puertas = cd.codigo\n"
            + "where e.id_puerta = :idPuerta",
            nativeQuery = true)
    public PuertasProjection obtenerPuertaById(@Param("idPuerta") String idPuerta);
}
