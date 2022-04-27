package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.AvionesModel;
import com.gt.aeropuerto.projections.AvionesProjections;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface AvionesRepository extends CrudRepository<AvionesModel, String> {

    @Query(value = "select a.*, a2.nombre_aerolinea as \"detalleAerolinea\", cd.nombre as \"detalleEstado\" \n"
            + "from public.aviones a \n"
            + "inner join public.aerolineas a2 on a.aerolinea = a2.id_aerolinea\n"
            + "inner join public.cat_dato cd on a.estado_avion = cd.codigo",
            nativeQuery = true)
    public List<AvionesProjections> obtenerAllAviones();

    @Query(value = "select a.*, a2.nombre_aerolinea as \"detalleAerolinea\", cd.nombre as \"detalleEstado\"\n"
            + "from public.aviones a \n"
            + "inner join public.aerolineas a2 on a.aerolinea = a2.id_aerolinea\n"
            + "inner join public.cat_dato cd on a.aerolinea = cd.codigo\n"
            + "where a.id_avion = :idAvion",
            nativeQuery = true)
    public AvionesProjections obtenerAvionesById(@Param("idAvion") String idAvion);
}
