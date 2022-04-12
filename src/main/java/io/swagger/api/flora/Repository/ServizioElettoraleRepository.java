package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioElettorale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioElettoraleRepository extends MongoRepository<ServizioElettorale,String> {
    ServizioElettorale save(ServizioElettorale servizioElettorale);

    List<ServizioElettorale> findAll();
}
