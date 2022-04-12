package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioMandati;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioMandatiRepository extends MongoRepository<UfficioMandati,String> {
    UfficioMandati save(UfficioMandati ufficioMandati);

    List<UfficioMandati> findAll();
}
