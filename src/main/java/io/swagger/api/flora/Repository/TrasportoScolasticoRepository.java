package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.TrasportoScolastico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrasportoScolasticoRepository extends MongoRepository<TrasportoScolastico,String> {
    TrasportoScolastico save(TrasportoScolastico trasportoScolastico);

    List<TrasportoScolastico> findAll();
}
