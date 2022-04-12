package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioEconomato;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioEconomatoRepository extends MongoRepository<UfficioEconomato,String> {
    UfficioEconomato save(UfficioEconomato ufficioEconomato);

    List<UfficioEconomato> findAll();
}
