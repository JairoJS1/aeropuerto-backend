package com.gt.aeropuerto.services;

import com.gt.aeropuerto.Dtos.EscalasDto;
import com.gt.aeropuerto.models.EscalasModel;
import com.gt.aeropuerto.projections.EscalasProjection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gt.aeropuerto.repositories.EscalasRepository;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
@Transactional
public class EscalaServices {

    @Autowired
    EscalasRepository escalasInterface;

    @Transactional(rollbackFor = {Exception.class})
    public Boolean crearEscala(EscalasDto escalas) {

        try {
            final EscalasModel crearEscala = escalasInterface.save(
                    EscalasModel.builder()
                            .paisEscala(escalas.getPaisEscala())
                            .ciudadEscala(escalas.getCiudadEscala())
                            .estadoEscalas(escalas.getEstadoEscalas())
                            .build()
            );
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear aerolinea: " + e);
            return false;
        }

    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean actualizarEscala(Integer idAerolinea, EscalasDto dto) {
        log.debug("Consultando escala");
        final EscalasModel escalas = escalasInterface.findById(idAerolinea).orElse(null);
        if (escalas != null) {
            escalas.setPaisEscala(dto.getPaisEscala());
            escalas.setCiudadEscala(dto.getCiudadEscala());
            escalas.setEstadoEscalas(dto.getEstadoEscalas());
            return true;
        } else {
            log.info("No exite la escala indicada");
            return false;
        }

    }

      public List<EscalasProjection> obtnerAllAerolinea(){
        return escalasInterface.obtenerAllEscalas();
    }
    
    public EscalasProjection obtnerAerolineaById(Integer idEscala){
        return escalasInterface.obteneEscalaById(idEscala);
    }
}
