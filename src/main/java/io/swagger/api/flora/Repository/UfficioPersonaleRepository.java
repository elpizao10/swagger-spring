package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioPersonale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioPersonaleRepository extends MongoRepository<UfficioPersonale,String> {
    UfficioPersonale save(UfficioPersonale ufficioPersonale);

    List<UfficioPersonale> findAll();
}
