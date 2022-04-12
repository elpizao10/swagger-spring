package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Sindaco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SindacoRepository extends MongoRepository<Sindaco,String> {
    Sindaco save(Sindaco sindaco);

    List<Sindaco> findAll();
}
