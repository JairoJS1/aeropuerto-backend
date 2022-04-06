/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.VueloModel;
import com.gt.aeropuerto.projections.VuelosProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface VueloRepository extends CrudRepository<VueloModel, String> {

    @Query(value = "select  \n"
            + "v.*, (select p.numeropuerta from public.puertas p where p.id_puerta = v.id_puerta) as \"DetallePuerta\",\n"
            + "(select e.pais from public.escalas e where e.id_escala = v.id_escala)\"DetalleEscala\",\n"
            + "cd.nombre as \"DetalleEstadoVuelo\", cd2.nombre as \"DetalleDestinoPais\", cd3.nombre as \"DetalleOrigen\", cd2.descripcion as \"DetalleDestino\"\n"
            + "from public.vuelo v\n"
            + "inner join public.cat_dato cd on v.estado_vuelo = cd.codigo\n"
            + "inner join public.cat_dato cd2 on v.destino = cd2.codigo \n"
            + "inner join public.cat_dato cd3 on v.origen = cd3.codigo ",
            nativeQuery = true)
    public List<VuelosProjection> obtenerAllVuelo();

    @Query(value = "select  \n"
            + "v.*, (select p.numeropuerta from public.puertas p where p.id_puerta = v.id_puerta) as \"DetallePuerta\",\n"
            + "(select e.pais from public.escalas e where e.id_escala = v.id_escala)\"DetalleEscala\",\n"
            + "cd.nombre as \"DetalleEstadoVuelo\", cd2.nombre as \"DetalleDestinoPais\", cd3.nombre as \"DetalleOrigen\", cd2.descripcion as \"DetalleDestino\"\n"
            + "from public.vuelo v\n"
            + "inner join public.cat_dato cd on v.estado_vuelo = cd.codigo\n"
            + "inner join public.cat_dato cd2 on v.destino = cd2.codigo \n"
            + "inner join public.cat_dato cd3 on v.origen = cd3.codigo \n"
            + "where v.numero_vuelo = :numeroVuelo",
            nativeQuery = true)
    public VuelosProjection obteneVueloById(@Param("numeroVuelo") String numeroVuelo);
}
