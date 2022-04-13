package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.ActualizarBoletoDto;
import com.gt.aeropuerto.Dtos.CrearBoletoDto;
import com.gt.aeropuerto.Dtos.RespuestaBoletoDto;
import com.gt.aeropuerto.models.BoletoModel;
import com.gt.aeropuerto.models.PasajeroModel;
import com.gt.aeropuerto.projections.BoletoProjection;
import com.gt.aeropuerto.repositories.BoletoRepository;
import com.gt.aeropuerto.repositories.PasajeroRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
@Transactional
public class BoletoServices {

    @Autowired
    BoletoRepository boletoRepository;

    @Autowired
    PasajeroRepository pasajeroRepository;

    @Transactional(rollbackFor = {Exception.class})
    public RespuestaBoletoDto crearBoleto(CrearBoletoDto crearDto) {
        log.debug("Creando Boleto...");
        PasajeroModel pasajero = pasajeroRepository.obtenerPasajero(crearDto.getNumeroPasaporte());
        if (pasajero == null) {
            pasajero = pasajeroRepository.save(
                    PasajeroModel.builder()
                            .numeroPasaporte(crearDto.getNumeroPasaporte())
                            .nombrePasajero(crearDto.getNombrePasajero())
                            .apellidoPasajero(crearDto.getApellidoPasajero())
                            .build()
            );
        }
        final BoletoModel boleto = boletoRepository.save(
                BoletoModel.builder()
                        .fechaCreacion(crearDto.getFechaCreacion())
                        .numeroAsiento(crearDto.getNumeroAsiento())
                        .estadoBoleto(crearDto.getEstadoBoleto())
                        .presentacion(false)
                        .idPasajero(pasajero.getIdPasajero())
                        .numeroVuelo(crearDto.getNumeroVuelo())
                        .build()
        );

        boleto.setNumeroBoleto("N" + "-" + boleto.getIdBoleto() + "-" + boleto.getNumeroVuelo());

        return new RespuestaBoletoDto(boleto.getNumeroBoleto(), boleto.getIdBoleto());
    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean actualizarBoleto(Integer idBoleto, ActualizarBoletoDto dto) {
        log.debug("Consultando boleto");
        final BoletoModel boleto = boletoRepository.findById(idBoleto).orElse(null);
        if (boleto != null) {
            boleto.setEstadoBoleto(dto.getEstadoBoleto());
            boleto.setPresentacion(dto.getPresentacion());
            return true;
        } else {
            log.info("No exite el boleto indicado");
            return false;
        }
    }

    public List<BoletoProjection> obtenerBoletos() {
        return boletoRepository.obtenerAllBoletos();
    }

    public BoletoProjection obtenerBoletoById(Integer idBoleto) {
        return boletoRepository.obtenerBoletosById(idBoleto);
    }

}
