
package com.gt.aeropuerto.repositories;

import com.gt.aeropuerto.models.CatEstadoCatalogo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author JairoJS
 */
public interface CatEstadoCatalogoRepository extends CrudRepository<CatEstadoCatalogo, Integer>{
    
}
