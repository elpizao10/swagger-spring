package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioSegretariatoSociale;
import io.swagger.api.flora.model.ServizioSegretariatoSociale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioSegretariatoSocialeRepository extends MongoRepository<ServizioSegretariatoSociale,String> {
    ServizioSegretariatoSociale save(ServizioSegretariatoSociale servizioSegretariatoSociale);

    List<ServizioSegretariatoSociale> findAll();

}
