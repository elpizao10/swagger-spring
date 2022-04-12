package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.CircolareUrbana;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CircolaUrbanaRepository extends MongoRepository<CircolareUrbana,String> {
    CircolareUrbana save(CircolareUrbana circolareUrbana);
    List<CircolareUrbana> findAll();
}
