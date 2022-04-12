package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.ContenitoriCulturali;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContenitoriCulturaliRepository extends MongoRepository<ContenitoriCulturali,String> {

    ContenitoriCulturali save(ContenitoriCulturali contenitoriCulturali);
    List<ContenitoriCulturali> findAll();
}
