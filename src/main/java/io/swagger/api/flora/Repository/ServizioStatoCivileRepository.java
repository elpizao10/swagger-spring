package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ServizioStatoCivile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServizioStatoCivileRepository extends MongoRepository<ServizioStatoCivile,String> {
    ServizioStatoCivile save(ServizioStatoCivile servizioStatoCivile);

    List<ServizioStatoCivile> findAll();
}
