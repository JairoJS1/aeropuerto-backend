/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.BoletoModel;
import com.gt.aeropuerto.projections.BoletoCrearProjection;
import com.gt.aeropuerto.projections.BoletoProjection;
import com.gt.aeropuerto.projections.BoletoVueloProjection;
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

    @Query(value = "select distinct p.nombre_pasajero as \"nombrePasajero\", b.numero_vuelo as \"numeroVuelo\", b.numero_boleto as \"numeroBoleto\",\n"
            + "b.numero_boleto as \"numeroBoleto2\", v.hora_salida as \"horaAbordaje\", v.hora_salida as \"fechaAbordaje\", v.hora_llegada as \"horaAterrizaje\",\n"
            + "cd.nombre as \"origenVuelo\", cd2.nombre as \"destinoVuelo\", b.numero_asiento as \"numeroAsiento\" \n"
            + "from public.pasajero p \n"
            + "inner join public.boleto b on p.id_pasajero = b.id_pasajero \n"
            + "inner join public.vuelo v on b.numero_vuelo = v.numero_vuelo \n"
            + "inner join public.cat_dato cd on v.origen = cd.codigo \n"
            + "inner join public.cat_dato cd2 on v.destino = cd2.codigo \n"
            + "where b.id_boleto = :idBoleto",
            nativeQuery = true)
    public BoletoCrearProjection obtenerInfo(@Param("idBoleto") Integer idBoleto);

    @Query(value = "select distinct  \n"
            + "p.nombre_pasajero \"nombrePasajero\", p.apellido_pasajero \"apellidoPasajero\",\n"
            + "p.numero_pasaporte \"numeroPasaporte\", b.numero_vuelo \"numeroVuelo\", a2.nombre_aerolinea \"nombreAerolinea\",\n"
            + "a.aerolinea \"idAerolinea\", cd.nombre \"origen\", cd2.nombre \"destino\", cd2.descripcion \"descDestino\",\n"
            + "v.hora_salida \"horaDespegue\", v.hora_llegada \"horaAterrizaje\", \n"
            + "v.estado_vuelo \"idEstadoVuelo\", cd3.nombre \"EstadoVuelo\", b.numero_boleto \"numeroBoleto\",\n"
            + "v.id_escala \"idEscala\", e.ciudad \"escalaCiudad\", e.pais \"escalaPais\", b.id_boleto  \"idBoleto\" \n"
            + "from public.pasajero p \n"
            + "inner join public.boleto b on p.id_pasajero = b.id_pasajero \n"
            + "inner join public.vuelo v on b.numero_vuelo = v.numero_vuelo \n"
            + "inner join public.escalas e on v.id_escala = e.id_escala \n"
            + "inner join public.aviones a on v.id_avion  = a.id_avion \n"
            + "inner join public.aerolineas a2 on a.aerolinea = a2.id_aerolinea \n"
            + "inner join public.cat_dato cd on v.origen = cd.codigo \n"
            + "inner join public.cat_dato cd2 on v.destino = cd2.codigo \n"
            + "inner join public.cat_dato cd3 on v.estado_vuelo  = cd3.codigo \n"
            + "where b.numero_boleto = :numeroBoleto and b.estado_boleto <> 13",
            nativeQuery = true)
    public BoletoVueloProjection obtenerVueloByBoleto(@Param("numeroBoleto") String numeroBoleto);
}
