package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.StruttureSportive;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StruttureSportiveRepository extends MongoRepository<StruttureSportive,String> {
    StruttureSportive save(StruttureSportive struttureSportive);

    List<StruttureSportive> findAll();
}
