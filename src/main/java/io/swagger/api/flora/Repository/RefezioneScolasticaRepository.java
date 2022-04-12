package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.RefezioneScolastica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RefezioneScolasticaRepository extends MongoRepository<RefezioneScolastica,String> {
    RefezioneScolastica save(RefezioneScolastica refezioneScolastica);
    List<RefezioneScolastica> findAll();
}
