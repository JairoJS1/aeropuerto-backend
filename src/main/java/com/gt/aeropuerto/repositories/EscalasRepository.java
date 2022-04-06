/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.EscalasModel;
import com.gt.aeropuerto.projections.EscalasProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface EscalasRepository extends CrudRepository<EscalasModel, Integer> {

    @Query(value = "select e.*,  cd.nombre as \"detalleEstadoEscala\" \n"
            + "from public.escalas e\n"
            + "inner join public.cat_dato cd on e.estado_escalas = cd.codigo",
            nativeQuery = true)
    public List<EscalasProjection> obtenerAllEscalas();

    @Query(value = "select e.*,  cd.nombre as \"detalleEstadoEscala\" \n"
            + "from public.escalas e\n"
            + "inner join public.cat_dato cd on e.estado_escalas = cd.codigo\n"
            + "where e.id_escala = :idEscala",
            nativeQuery = true)
    public EscalasProjection obteneEscalaById(@Param("idEscala") Integer idEscala);
}
