/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.BoletoModel;
import com.gt.aeropuerto.projections.BoletoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface BoletoRepository extends CrudRepository<BoletoModel, Integer> {

    public BoletoRepository findByNumeroBoleto(String numeroBoleto);

    @Query(value = "select b.*, cd.nombre as \"DetalleEstado\", p.nombre_pasajero , p.apellido_pasajero from public.boleto b \n"
            + "inner join public.cat_dato cd on b.estado_boleto = cd.codigo \n"
            + "inner join public.pasajero p on b.id_pasajero = p.id_pasajero",
            nativeQuery = true)
    public List<BoletoProjection> obtenerAllBoletos();

    @Query(value = "select b.*, cd.nombre as \"DetalleEstado\", p.nombre_pasajero , p.apellido_pasajero from public.boleto b \n"
            + "inner join public.cat_dato cd on b.estado_boleto = cd.codigo \n"
            + "inner join public.pasajero p on b.id_pasajero = p.id_pasajero\n"
            + "where b.id_boleto = :idBoleto",
            nativeQuery = true)
    public BoletoProjection obtenerBoletosById(@Param("idBoleto") Integer idBoleto);
}
