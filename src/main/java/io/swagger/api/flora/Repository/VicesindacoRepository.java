package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Vicesindaco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VicesindacoRepository extends MongoRepository<Vicesindaco,String> {
    Vicesindaco save(Vicesindaco vicesindaco);

    List<Vicesindaco> findAll();
}
