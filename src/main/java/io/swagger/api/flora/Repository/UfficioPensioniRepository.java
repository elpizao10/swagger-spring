package io.swagger.api.flora.Repository;

import io.swagger.api.flora.model.UfficioPensioni;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UfficioPensioniRepository extends MongoRepository<UfficioPensioni,String> {
    UfficioPensioni save(UfficioPensioni ufficioPensioni);

    List<UfficioPensioni> findAll();
}
