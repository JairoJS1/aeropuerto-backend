/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.EmpleadoModel;
import com.gt.aeropuerto.projections.AerolineasProjection;
import com.gt.aeropuerto.projections.EmpleadosProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author denis
 */
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, String> {

    @Query(value = "select e.*,  cd.nombre as \"detalleEmpleado\", cdc.nombre as \"detalleEstado\" \n"
            + "from public.empleados e\n"
            + "inner join public.cat_dato cd on e.departamento = cd.codigo \n"
            + "inner join public.cat_dato cdc on e.estado_empleado = cdc.codigo",
            nativeQuery = true)
    public List<EmpleadosProjection> obtenerAllEmpleados();

    @Query(value = "select e.*,  cd.nombre as \"detalleEmpleado\", cdc.nombre as \"detalleEstado\" \n"
            + "from public.empleados e \n"
            + "inner join public.cat_dato cd on e.departamento = cd.codigo \n"
            + "inner join public.cat_dato cdc on e.estado_empleado = cdc.codigo\n"
            + "where e.dpi = :dpi",
            nativeQuery = true)
    public EmpleadosProjection obtenerEmpleadobyDPI(@Param("dpi") String dpiEmpleado);
}
