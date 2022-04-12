package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioStatistica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioStatisticaRepository extends MongoRepository<UfficioStatistica,String> {
    UfficioStatistica save(UfficioStatistica ufficioStatistica);

    List<UfficioStatistica> findAll();
}
