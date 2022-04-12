package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.StruttureSportviveComunali;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StruttureSportviveComunaliRepository extends MongoRepository<StruttureSportviveComunali,String> {
    StruttureSportviveComunali save(StruttureSportviveComunali struttureSportviveComunali);

    List<StruttureSportviveComunali> findAll();
}
