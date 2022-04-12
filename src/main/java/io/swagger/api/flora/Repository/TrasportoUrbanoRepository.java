package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.TrasportoUrbano;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrasportoUrbanoRepository extends MongoRepository<TrasportoUrbano,String> {
    TrasportoUrbano save(TrasportoUrbano trasportoUrbano);

    List<TrasportoUrbano> findAll();
}
