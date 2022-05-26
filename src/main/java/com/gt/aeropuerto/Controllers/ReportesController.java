/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Controllers;

import com.gt.aeropuerto.Dtos.ReporteVuelosDto;
import com.gt.aeropuerto.Dtos.ReporteVuelosRespuestaDto;
import com.gt.aeropuerto.services.ReporteServices;
//import com.gt.aeropuerto.utils.ReportesUtils;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JairoJS
 */
@RestController
@Slf4j
public class ReportesController {

    @Autowired
    ReporteServices reportesServices;
    
//    @PostMapping(value = "/reporte/servicios/{exportFormat}")
//    public List<ReporteVuelosRespuestaDto> reporteServicios(@RequestBody ReporteVuelosDto parametros,
//            HttpServletResponse response,
//            @PathVariable String exportFormat) {
//
//        final List<ReporteVuelosRespuestaDto> resultado = reportesServices.obtenerReporteServicios(parametros);
//
//        if (!exportFormat.equals("info")) {
//           // ReportesUtils.crearReporte(resultado, "reporte-vuelos.jrxml", response, exportFormat);
//        }
//        return resultado;
//    }
}
