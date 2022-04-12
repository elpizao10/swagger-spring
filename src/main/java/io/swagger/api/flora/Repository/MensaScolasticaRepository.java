package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.MensaScolastica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MensaScolasticaRepository extends MongoRepository<MensaScolastica,String> {
    MensaScolastica save(MensaScolastica mensaScolastica);
    List<MensaScolastica> findAll();
}
