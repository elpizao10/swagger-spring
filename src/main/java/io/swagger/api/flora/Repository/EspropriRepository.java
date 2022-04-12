package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Espropri;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EspropriRepository extends MongoRepository<Espropri,String> {
    Espropri save(Espropri espropri);
    List<Espropri> findAll();

}
