/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.Dtos.ReporteVuelosDto;
import com.gt.aeropuerto.Dtos.ReporteVuelosRespuestaDto;
import com.gt.aeropuerto.utils.ReportesUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JairoJS
 */
@Repository
public class GeneralRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReporteVuelosRespuestaDto> obtenerReporteServicios(ReporteVuelosDto dto) {
        String query = "select distinct row_number() over (order by v.hora_llegada nulls last) as id, v.numero_vuelo, v.hora_llegada,\n"
                + "v.hora_salida, cd3.descripcion destino, cd2.nombre origen, e.pais escala, cd.nombre as estado_vuelo\n"
                + "from public.vuelo v \n"
                + "inner join public.cat_dato cd on v.estado_vuelo = cd.codigo \n"
                + "inner join public.cat_dato cd2 on v.origen = cd2.codigo \n"
                + "inner join public.cat_dato cd3 on v.destino = cd3.codigo \n"
                + "inner join public.escalas e on v.id_escala = e.id_escala ";

        return ReportesUtils.createCompiledQuery(entityManager, query, dto, ReporteVuelosRespuestaDto.class).getResultList();
    }
}
