/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.AerolineasModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author denis
 */
public interface AerolineasRepository extends CrudRepository<AerolineasModel, Integer> {

    @Query(value = "select a.*,  cd.nombre as \"detalleAerolinea\" \n"
            + "from public.aerolineas a\n"
            + "inner join public.cat_dato cd on a.id_aerolinea = cd.codigo",
            nativeQuery = true)
    public List<AerolineasProjection> obtenerAllAerolineas();

    @Query(value = "select a.*,  cd.nombre as \"detalleAerolinea\" \n"
            + "from public.aerolineas a\n"
            + "inner join public.cat_dato cd on a.id_aerolinea = cd.codigo\n"
            + "where a.id_aerolinea = :idAerolinea",
            nativeQuery = true)
    public AerolineasProjection obtenerAerolineaById(@Param("idAerolinea") Integer idAerolinea);
}
