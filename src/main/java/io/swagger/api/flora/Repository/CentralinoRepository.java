package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.Centralino;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CentralinoRepository extends MongoRepository <Centralino, String> {

    Centralino save(Centralino centralino);
    List<Centralino> findAll();

}
