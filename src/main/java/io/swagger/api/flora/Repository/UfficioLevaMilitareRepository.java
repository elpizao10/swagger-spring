package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioLevaMilitare;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioLevaMilitareRepository extends MongoRepository<UfficioLevaMilitare,String> {
    UfficioLevaMilitare save(UfficioLevaMilitare ufficioLevaMilitare);

    List<UfficioLevaMilitare> findAll();
}
