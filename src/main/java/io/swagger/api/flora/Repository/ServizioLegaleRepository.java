package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioLegale;
import io.swagger.api.flora.model.ServizioLegale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioLegaleRepository extends MongoRepository<ServizioLegale,String> {
    ServizioLegale save(ServizioLegale servizioLegale);

    List<ServizioLegale> findAll();


}
