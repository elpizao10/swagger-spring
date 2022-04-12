package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.BeniCulturali;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BeniCulturaliRepository extends MongoRepository<BeniCulturali,String> {
    BeniCulturali save(BeniCulturali beniCulturali);


    List<BeniCulturali> findAll();
}
