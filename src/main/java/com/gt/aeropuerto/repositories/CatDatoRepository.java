/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.CatDatoModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JairoJS
 */
public interface CatDatoRepository extends CrudRepository<CatDatoModel, Integer> {

    public List<CatDatoModel> findByCodigoCatalogo(@Param("codigo") int codigoIngresado);

    @Query(value = "select * from public.cat_dato where codigo_catalogo = 7 and codigo <> 43",
            nativeQuery = true)
    public List<CatDatoModel> obtenerCatalogo();
}
