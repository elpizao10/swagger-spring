package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.TurismoRurale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TurismoRuraleRepository extends MongoRepository<TurismoRurale,String> {
    TurismoRurale save(TurismoRurale turismoRurale);

    List<TurismoRurale> findAll();
}
